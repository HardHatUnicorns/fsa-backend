package pl.aogiri.hhu.fsa.backend.showtime.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaFacilityRepository;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.request.AddShowtimeRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.mapper.ShowtimeMapper;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;
import pl.aogiri.hhu.fsa.backend.showtime.domain.repository.ShowtimeRepository;
import pl.aogiri.hhu.fsa.backend.showtime.exception.ShowtimeNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;
    private final CinemaFacilityRepository cinemaFacilityRepository;
    private final EntityManager entityManager;

    public ShowtimeDto getShowtimeDetails(Long showtimeId) {
        return showtimeRepository.findById(showtimeId)
                .map(ShowtimeMapper::toDto)
                .orElseThrow(() -> new ShowtimeNotFoundException(showtimeId));
    }

    public List<ShowtimeDto> getShowtimesByCriteria(ShowtimeCriteriaRequest request) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<ShowtimeEntity> criteriaQuery = criteriaBuilder.createQuery(ShowtimeEntity.class);
        final Root<ShowtimeEntity> showtimeRoot = criteriaQuery.from(ShowtimeEntity.class);
        final ArrayList<Predicate> predicates = new ArrayList<>();

        if (request.getMovieId() != null)
            predicates.add(criteriaBuilder.equal(showtimeRoot.get("movie").get("id"), request.getMovieId()));
        if (request.getFacilityId() != null)
            predicates.add(criteriaBuilder.equal(showtimeRoot.get("cinemaFacility").get("id"), request.getFacilityId()));

        if (request.getFromDate() != null && request.getToDate() != null)
            predicates.add(criteriaBuilder.between(showtimeRoot.get("datetime"), request.getFromDate(), request.getToDate()));
        else if (request.getFromDate() != null)
            predicates.add(criteriaBuilder.greaterThan(showtimeRoot.get("datetime"), request.getFromDate()));
        else if (request.getToDate() != null)
            predicates.add(criteriaBuilder.lessThan(showtimeRoot.get("datetime"), request.getToDate()));
        else
            predicates.add(criteriaBuilder.greaterThan(showtimeRoot.get("datetime"), LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT)));

        if (request.getShowtimeVideoType() != null)
            predicates.add(criteriaBuilder.equal(showtimeRoot.get("videoType"), request.getShowtimeVideoType()));
        if (request.getShowtimeTextSourceType() != null)
            predicates.add(criteriaBuilder.equal(showtimeRoot.get("textType"), request.getShowtimeTextSourceType()));
        if (request.getLanguage() != null)
            predicates.add(criteriaBuilder.equal(showtimeRoot.get("textLanguage"), request.getLanguage()));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery)
                .getResultList()
                .stream()
                .map(ShowtimeMapper::toDto)
                .toList();
    }
    
    public ShowtimeEntity addShowtime(AddShowtimeRequest addShowtimeRequest) {
        final var movie = movieRepository.findById(addShowtimeRequest.getMovieId());
        final var cinemaFacility = cinemaFacilityRepository.findById(addShowtimeRequest.getCinemaFacilityId());

        if (movie.isEmpty())
            throw new IllegalStateException("Provided movie is incorrect");
        if (cinemaFacility.isEmpty())
            throw new IllegalStateException("Provided cinema facility is incorrect");

        final var entity = ShowtimeMapper.toEntity(addShowtimeRequest, movie.get(), cinemaFacility.get());
        return showtimeRepository.save(entity);
    }
}

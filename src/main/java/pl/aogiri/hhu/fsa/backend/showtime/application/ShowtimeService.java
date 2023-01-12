package pl.aogiri.hhu.fsa.backend.showtime.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaFacilityRepository;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.request.AddShowtimeRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.mapper.ShowtimeMapper;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;
import pl.aogiri.hhu.fsa.backend.showtime.domain.repository.ShowtimeRepository;
import pl.aogiri.hhu.fsa.backend.showtime.exception.ShowtimeNotFoundException;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;
    private final CinemaFacilityRepository cinemaFacilityRepository;

    public ShowtimeDto getShowtimeDetails(Long showtimeId) {
        return showtimeRepository.findById(showtimeId)
                .map(ShowtimeMapper::toDto)
                .orElseThrow(() -> new ShowtimeNotFoundException(showtimeId));
    }

    public List<ShowtimeDto> getShowtimes(ShowtimeCriteriaRequest showtimeCriteriaRequest) {
        return showtimeRepository.findAll()
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

package pl.aogiri.hhu.fsa.backend.showtime.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.request.AddShowtimeRequest;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;

public class ShowtimeMapper {

    public static ShowtimeDto toDto(ShowtimeEntity showtimeEntity) {
        final var showtimeDto = new ShowtimeDto();
        showtimeDto.setId(showtimeEntity.getId());
        showtimeDto.setMovieTitle(showtimeEntity.getMovie().getTitle());
        showtimeDto.setVideoType(showtimeEntity.getVideoType());
        showtimeDto.setTextType(showtimeEntity.getTextType());
        showtimeDto.setTextLanguage(showtimeEntity.getTextLanguage());
        showtimeDto.setDatetime(showtimeEntity.getDatetime());
        return showtimeDto;
    }

    public static ShowtimeEntity toEntity(AddShowtimeRequest addShowtimeRequest, MovieEntity movie, CinemaFacilityEntity cinemaFacilityEntity) {
        final var showtimeEntity = new ShowtimeEntity();
        showtimeEntity.setMovie(movie);
        showtimeEntity.setCinemaFacility(cinemaFacilityEntity);
        showtimeEntity.setVideoType(addShowtimeRequest.getVideoType());
        showtimeEntity.setTextType(addShowtimeRequest.getTextType());
        showtimeEntity.setTextLanguage(addShowtimeRequest.getTextLanguage());
        showtimeEntity.setDatetime(addShowtimeRequest.getDatetime());
        return showtimeEntity;
    }
}

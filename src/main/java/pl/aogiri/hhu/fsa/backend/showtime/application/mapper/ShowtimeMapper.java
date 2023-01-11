package pl.aogiri.hhu.fsa.backend.showtime.application.mapper;

import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
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
}

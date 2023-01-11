package pl.aogiri.hhu.fsa.backend.showtime.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityDetailsDtoFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieEntityFixture;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeTextSourceType;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeVideoType;

import java.time.LocalDateTime;

public class ShowtimeDtoFixture {

    public static ShowtimeDto showtimeTheIncrediblesInCinemaCityBonarka() {
        final var showtimeDto = new ShowtimeDto();
        showtimeDto.setId(1L);
        showtimeDto.setMovieTitle(MovieEntityFixture.theIncredibles().getTitle());
        showtimeDto.setCinemaFacilityName(CinemaFacilityDetailsDtoFixture.cinemaCityBonarka().getName());
        showtimeDto.setVideoType(ShowtimeVideoType._2D);
        showtimeDto.setTextType(ShowtimeTextSourceType.DUB);
        showtimeDto.setTextLanguage("Polish");
        showtimeDto.setDatetime(LocalDateTime.of(2023, 2, 5, 10, 15));
        return showtimeDto;
    }

    public static ShowtimeDto showtimeAvatarTheWayOfWaterInCinemaCityBonarka() {
        final var showtimeDto = new ShowtimeDto();
        showtimeDto.setId(2L);
        showtimeDto.setMovieTitle(MovieEntityFixture.avatarTheWayOfWater().getTitle());
        showtimeDto.setCinemaFacilityName(CinemaFacilityDetailsDtoFixture.cinemaCityBonarka().getName());
        showtimeDto.setVideoType(ShowtimeVideoType._3D);
        showtimeDto.setTextType(ShowtimeTextSourceType.SUB);
        showtimeDto.setTextLanguage("Polish");
        showtimeDto.setDatetime(LocalDateTime.of(2023, 2, 5, 20, 0));
        return showtimeDto;
    }
}

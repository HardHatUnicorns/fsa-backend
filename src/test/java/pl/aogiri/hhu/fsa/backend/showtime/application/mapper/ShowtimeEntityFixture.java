package pl.aogiri.hhu.fsa.backend.showtime.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityEntityFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieEntityFixture;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeTextSourceType;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeVideoType;

import java.time.LocalDateTime;

public class ShowtimeEntityFixture {

    public static ShowtimeEntity showtimeTheIncrediblesInCinemaCityBonarka() {
        final var showtimeEntity = new ShowtimeEntity();
        showtimeEntity.setId(1L);
        showtimeEntity.setMovie(MovieEntityFixture.theIncredibles());
        showtimeEntity.setCinemaFacility(CinemaFacilityEntityFixture.cinemaCityBonarka());
        showtimeEntity.setVideoType(ShowtimeVideoType._2D);
        showtimeEntity.setTextType(ShowtimeTextSourceType.DUB);
        showtimeEntity.setTextLanguage("Polish");
        showtimeEntity.setDatetime(LocalDateTime.of(2023, 2, 5, 10, 15));
        return showtimeEntity;
    }

    public static ShowtimeEntity showtimeAvatarTheWayOfWaterInCinemaCityBonarka() {
        final var showtimeEntity = new ShowtimeEntity();
        showtimeEntity.setId(2L);
        showtimeEntity.setMovie(MovieEntityFixture.avatarTheWayOfWater());
        showtimeEntity.setCinemaFacility(CinemaFacilityEntityFixture.cinemaCityBonarka());
        showtimeEntity.setVideoType(ShowtimeVideoType._3D);
        showtimeEntity.setTextType(ShowtimeTextSourceType.SUB);
        showtimeEntity.setTextLanguage("Polish");
        showtimeEntity.setDatetime(LocalDateTime.of(2023, 2, 5, 20, 0));
        return showtimeEntity;
    }
}

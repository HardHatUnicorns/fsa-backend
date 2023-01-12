package pl.aogiri.hhu.fsa.backend.showtime.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityEntityFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieEntityFixture;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.request.AddShowtimeRequest;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeTextSourceType;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeVideoType;

import java.time.LocalDateTime;

public class AddShowtimeRequestFixture {

    public static AddShowtimeRequest showtimeTheIncrediblesInCinemaCityBonarka() {
        final var addShowtimeRequest = new AddShowtimeRequest();
        addShowtimeRequest.setMovieId(MovieEntityFixture.theIncredibles().getId());
        addShowtimeRequest.setCinemaFacilityId(CinemaFacilityEntityFixture.cinemaCityBonarka().getId());
        addShowtimeRequest.setVideoType(ShowtimeVideoType._2D);
        addShowtimeRequest.setTextType(ShowtimeTextSourceType.DUB);
        addShowtimeRequest.setTextLanguage("Polish");
        addShowtimeRequest.setDatetime(LocalDateTime.of(2023, 2, 5, 10, 15));

        return addShowtimeRequest;
    }
}

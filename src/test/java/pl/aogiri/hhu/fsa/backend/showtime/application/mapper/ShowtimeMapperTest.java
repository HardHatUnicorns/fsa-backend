package pl.aogiri.hhu.fsa.backend.showtime.application.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityEntityFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieEntityFixture;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShowtimeMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = ShowtimeEntityFixture.showtimeTheIncrediblesInCinemaCityBonarka();

        //when
        final ShowtimeDto actualDto = ShowtimeMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(ShowtimeDtoFixture.showtimeTheIncrediblesInCinemaCityBonarka());
    }

    @Test
    public void requestEntityMapTest() {
        // given
        final var givenRequest = AddShowtimeRequestFixture.showtimeTheIncrediblesInCinemaCityBonarka();
        final var givenMovie = MovieEntityFixture.theIncredibles();
        final var givenCinemaFacility = CinemaFacilityEntityFixture.cinemaCityBonarka();

        // when
        final ShowtimeEntity createdEntity = ShowtimeMapper.toEntity(givenRequest, givenMovie, givenCinemaFacility);

        // then
        // id is set outside of the mapper, so setting it here is required
        createdEntity.setId(ShowtimeEntityFixture.showtimeTheIncrediblesInCinemaCityBonarka().getId());
        Assertions.assertThat(createdEntity).isEqualTo(ShowtimeEntityFixture.showtimeTheIncrediblesInCinemaCityBonarka());
    }
}

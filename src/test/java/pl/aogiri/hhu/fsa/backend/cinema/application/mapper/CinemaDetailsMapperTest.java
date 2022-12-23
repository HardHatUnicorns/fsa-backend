package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDetailsDto;

import static org.assertj.core.api.Assertions.assertThat;

class CinemaDetailsMapperTest {
    @Test
    public void entityDtoMapTest() {
        // given
        final var givenEntity = CinemaEntityFixture.cinemaCity();

        // when
        final CinemaDetailsDto actualDto = CinemaDetailsMapper.toDto(givenEntity);

        // then
        assertThat(actualDto).isEqualTo(CinemaDetailsDtoFixture.cinemaCity());
    }

}

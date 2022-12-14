package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.web.controller.CinemaDtoFixture;

import static org.assertj.core.api.Assertions.assertThat;

public class CinemaMapperTest {

    @Test
    public void entityDtoMapTest() {
        // given
        final var givenEntity = CinemaEntityFixture.cinemaCity();

        // when
        final CinemaDto actualDto = CinemaMapper.toDto(givenEntity);

        // then
        assertThat(actualDto).isEqualTo(CinemaDtoFixture.cinemaCity());
    }
}

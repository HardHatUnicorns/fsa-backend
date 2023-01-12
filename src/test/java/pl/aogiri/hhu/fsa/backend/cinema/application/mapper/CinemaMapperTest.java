package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;
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

    @Test
    public void requestEntityMapTest() {
        // given
        final var givenRequest = AddCinemaRequestFixture.cinemaCity();

        // when
        final CinemaEntity createdEntity = CinemaMapper.toEntity(givenRequest);

        // then
        assertThat(createdEntity.getName()).isEqualTo(CinemaEntityFixture.cinemaCity().getName());
        assertThat(createdEntity.getUrl()).isEqualTo(CinemaEntityFixture.cinemaCity().getUrl());
    }
}

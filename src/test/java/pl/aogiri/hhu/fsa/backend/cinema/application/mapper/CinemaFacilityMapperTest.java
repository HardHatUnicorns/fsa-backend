package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CinemaFacilityMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = CinemaFacilityEntityFixture.cinemaCityBonarka();

        //when
        final CinemaFacilityDto actualDto = CinemaFacilityMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(CinemaFacilityDtoFixture.cinemaCityBonarka());
    }

    @Test
    public void shouldSuccessfullyMapDtoToEntityWhenCorrectDtoIsGiven() {
        // given
        final var givenRequest = AddCinemaFacilityRequestFixture.cinemaCityBonarka();
        final CinemaEntity cinemaEntity = CinemaEntityFixture.cinemaCity();

        // when
        final CinemaFacilityEntity createdEntity = CinemaFacilityMapper.toEntity(cinemaEntity, givenRequest);

        // then
        assertThat(createdEntity).isEqualTo(CinemaFacilityEntityFixture.addCinemaCityBonarka(cinemaEntity));
    }
}

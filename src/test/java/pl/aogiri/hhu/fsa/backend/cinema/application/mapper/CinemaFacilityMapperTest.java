package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;

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

}
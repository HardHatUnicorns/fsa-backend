package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CinemaFacilityDetailsMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = CinemaFacilityEntityFixture.cinemaCityBonarka();

        //when
        final CinemaFacilityDetailsDto actualDto = CinemaFacilityDetailsMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(CinemaFacilityDetailsDtoFixture.cinemaCityBonarka());
    }
}

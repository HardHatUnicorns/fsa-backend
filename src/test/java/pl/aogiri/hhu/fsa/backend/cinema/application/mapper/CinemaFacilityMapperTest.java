package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;

import static org.junit.jupiter.api.Assertions.*;

class CinemaFacilityMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = CinemaFacilityEntityFixture.cinemaCityBonarka();
        final var expectedDto = CinemaFacilityDtoFixture.cinemaCityBonarka();

        //when
        final CinemaFacilityDto actualDto = CinemaFacilityMapper.toDto(givenEntity);

        //then
        assertNotNull(actualDto);
        assertEquals(expectedDto, actualDto);
    }

}
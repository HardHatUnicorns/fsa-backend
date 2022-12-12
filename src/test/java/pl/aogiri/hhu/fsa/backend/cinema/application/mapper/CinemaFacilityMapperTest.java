package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaFacilityNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CinemaFacilityMapperTest {

    @Test
    public void toDtoMethodShouldReturnDtoObjectIfProvideCorrectEntity() {
        //given
        Long id = 1L;
        String name = "Cinema City Bonarka";
        String address = "Henryka Kamieńskiego 11, 30-644 Kraków";
        CinemaFacilityEntity cinemaFacilityEntity = mock(CinemaFacilityEntity.class);
        when(cinemaFacilityEntity.getId()).thenReturn(id);
        when(cinemaFacilityEntity.getName()).thenReturn(name);
        when(cinemaFacilityEntity.getAddress()).thenReturn(address);

        Optional<CinemaFacilityEntity> cinemaFacilityEntityPossible = Optional.of(cinemaFacilityEntity);
        CinemaFacilityMapper cinemaFacilityMapper = new CinemaFacilityMapper();

        //when
        CinemaFacilityDto cinemaFacilityDto = cinemaFacilityMapper.toDto(cinemaFacilityEntityPossible);

        //then
        assertNotNull(cinemaFacilityDto);
        assertEquals(name, cinemaFacilityDto.getName());
        assertEquals(address, cinemaFacilityDto.getAddress());
        assertEquals(id, cinemaFacilityDto.getId());
    }

    @Test
    public void toDtoMethodShouldThrowExceptionIfCinemaFacilityEntityIsEmpty(){
        //given
        Optional<CinemaFacilityEntity> cinemaFacilityEntityPossible = Optional.empty();
        CinemaFacilityMapper cinemaFacilityMapper = new CinemaFacilityMapper();

        //when
        CinemaFacilityNotFoundException exception = assertThrows(CinemaFacilityNotFoundException.class,
                () -> cinemaFacilityMapper.toDto(cinemaFacilityEntityPossible));

        //then
        assertEquals("Try mapper null object.", exception.getMessage());
    }

}
package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaFacilityNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CinemaFacilityDetailsMapperTest {

    @Test
    public void toDtoMethodShouldReturnDtoObjectIfProvideCorrectEntity() {
        //given
        Long id = 1L;
        String name = "Cinema City Bonarka";
        String address = "Henryka Kamieńskiego 11, 30-644 Kraków";
        String description = "Example description for cinema facility.";
        String telephone = "600900100";
        String email = "bonarka@cinemacity.pl";
        CinemaFacilityEntity cinemaFacilityEntity = mock(CinemaFacilityEntity.class);
        when(cinemaFacilityEntity.getId()).thenReturn(id);
        when(cinemaFacilityEntity.getName()).thenReturn(name);
        when(cinemaFacilityEntity.getAddress()).thenReturn(address);
        when(cinemaFacilityEntity.getDescription()).thenReturn(description);
        when(cinemaFacilityEntity.getTelephone()).thenReturn(telephone);
        when(cinemaFacilityEntity.getEmail()).thenReturn(email);

        Optional<CinemaFacilityEntity> cinemaFacilityEntityPossible = Optional.of(cinemaFacilityEntity);
        CinemaFacilityDetailsMapper cinemaFacilityDetailsMapper = new CinemaFacilityDetailsMapper();

        //when
        CinemaFacilityDetailsDto cinemaFacilityDetailsDto = cinemaFacilityDetailsMapper.toDto(cinemaFacilityEntityPossible);

        //then
        assertNotNull(cinemaFacilityDetailsDto);
        assertEquals(name, cinemaFacilityDetailsDto.getName());
        assertEquals(address, cinemaFacilityDetailsDto.getAddress());
        assertEquals(id, cinemaFacilityDetailsDto.getId());
        assertEquals(description, cinemaFacilityDetailsDto.getDescription());
        assertEquals(telephone, cinemaFacilityDetailsDto.getTelephone());
        assertEquals(email, cinemaFacilityDetailsDto.getEmail());
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
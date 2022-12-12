package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

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

        CinemaFacilityMapper cinemaFacilityMapper = new CinemaFacilityMapper();

        //when
        CinemaFacilityDto cinemaFacilityDto = cinemaFacilityMapper.toDto(cinemaFacilityEntity);

        //then
        assertNotNull(cinemaFacilityDto);
        assertEquals(name, cinemaFacilityDto.getName());
        assertEquals(address, cinemaFacilityDto.getAddress());
        assertEquals(id, cinemaFacilityDto.getId());
    }

}
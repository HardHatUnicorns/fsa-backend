package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;

import java.util.List;

public class CinemaFacilityDtoFixture {
    public static CinemaFacilityDto cinemaCityBonarka(){
        final Long id = 1L;
        final String name = "Cinema City Bonarka";
        final String address = "Henryka Kamieńskiego 11, 30-644 Kraków";

        final CinemaFacilityDto cinemaFacilityDto = new CinemaFacilityDto();
        cinemaFacilityDto.setAddress(address);
        cinemaFacilityDto.setId(id);
        cinemaFacilityDto.setName(name);

        return cinemaFacilityDto;
    }

    public static CinemaFacilityDto cinemaCityGaleriaKazimierz(){
        final Long id = 2L;
        final String name = "Cinema City Galeria Kazimierz";
        final String address = "Podgórska 34, 31-536 Kraków";

        final CinemaFacilityDto dto = new CinemaFacilityDto();
        dto.setAddress(address);
        dto.setId(id);
        dto.setName(name);

        return dto;
    }

    public static List<CinemaFacilityDto> listOfFacility() {
        return List.of(cinemaCityGaleriaKazimierz(), cinemaCityBonarka());
    }
}

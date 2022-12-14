package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;

public class CinemaFacilityDtoFixture {

    public static CinemaFacilityDto cinemaCityBonarka() {
        final CinemaFacilityDto cinemaFacilityDto = new CinemaFacilityDto();
        cinemaFacilityDto.setId(1L);
        cinemaFacilityDto.setAddress("Henryka Kamieńskiego 11, 30-644 Kraków");
        cinemaFacilityDto.setName("Cinema City Bonarka");

        return cinemaFacilityDto;
    }

    public static CinemaFacilityDto cinemaCityGaleriaKazimierz() {
        final CinemaFacilityDto dto = new CinemaFacilityDto();
        dto.setId(2L);
        dto.setAddress("Podgórska 34, 31-536 Kraków");
        dto.setName("Cinema City Galeria Kazimierz");

        return dto;
    }
}

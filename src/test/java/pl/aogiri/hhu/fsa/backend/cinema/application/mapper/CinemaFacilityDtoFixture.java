package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;

public class CinemaFacilityDtoFixture {
    public static CinemaFacilityDto cinemaCityBonarka() {
        final CinemaFacilityDto cinemaFacilityDto = new CinemaFacilityDto();
        cinemaFacilityDto.setAddress("Henryka Kamieńskiego 11, 30-644 Kraków");
        cinemaFacilityDto.setId(1L);
        cinemaFacilityDto.setName("Cinema City Bonarka");

        return cinemaFacilityDto;
    }

    public static CinemaFacilityDto cinemaCityGaleriaKazimierz() {
        final CinemaFacilityDto dto = new CinemaFacilityDto();
        dto.setAddress("Podgórska 34, 31-536 Kraków");
        dto.setId(2L);
        dto.setName("Cinema City Galeria Kazimierz");

        return dto;
    }
}

package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;

public class CinemaFacilityDetailsDtoFixture {

    public static CinemaFacilityDetailsDto cinemaCityBonarka() {
        final CinemaFacilityDetailsDto dto = new CinemaFacilityDetailsDto();
        dto.setId(1L);
        dto.setName("Cinema City Bonarka");
        dto.setAddress("Henryka Kamieńskiego 11, 30-644 Kraków");
        dto.setDescription("Extra Cinema");
        dto.setTelephone("600900800");
        dto.setEmail("bonarka_cinema@cinema.pl");
        return dto;
    }

    public static CinemaFacilityDetailsDto cinemaCityGaleriaKazimierz() {
        final CinemaFacilityDetailsDto dto = new CinemaFacilityDetailsDto();
        dto.setId(2L);
        dto.setName("Cinema City Galeria Kazimierz");
        dto.setAddress("Podgórska 34, 31-536 Kraków");
        dto.setDescription("Fantastic Cinema");
        dto.setTelephone("200300400");
        dto.setEmail("Kazimierz_cinema@cinema.pl");

        return dto;
    }
}

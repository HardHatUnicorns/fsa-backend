package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

public class CinemaFacilityEntityFixture {
    public static CinemaFacilityEntity cinemaCityBonarka() {
        final CinemaFacilityEntity entity = new CinemaFacilityEntity();
        entity.setId(1L);
        entity.setName("Cinema City Bonarka");
        entity.setAddress("Henryka Kamieńskiego 11, 30-644 Kraków");

        return entity;
    }

    public static CinemaFacilityEntity cinemaCityGaleriaKazimierz() {
        final CinemaFacilityEntity entity = new CinemaFacilityEntity();
        entity.setId(2L);
        entity.setName("Cinema City Galeria Kazimierz");
        entity.setAddress("Podgórska 34, 31-536 Kraków");

        return entity;
    }
}

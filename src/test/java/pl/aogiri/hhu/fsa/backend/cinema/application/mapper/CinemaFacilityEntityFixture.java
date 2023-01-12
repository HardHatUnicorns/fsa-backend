package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

public class CinemaFacilityEntityFixture {
    public static CinemaFacilityEntity cinemaCityBonarka() {
        final CinemaFacilityEntity entity = new CinemaFacilityEntity();
        entity.setId(1L);
        entity.setName("Cinema City Bonarka");
        entity.setAddress("Henryka Kamieńskiego 11, 30-644 Kraków");
        entity.setDescription("Extra Cinema");
        entity.setTelephone("600900800");
        entity.setEmail("bonarka_cinema@cinema.pl");

        return entity;
    }

    public static CinemaFacilityEntity addCinemaCityBonarka(CinemaEntity cinemaEntity) {
        final CinemaFacilityEntity entity = new CinemaFacilityEntity();
        entity.setName("Cinema City Bonarka");
        entity.setAddress("Henryka Kamieńskiego 11, 30-644 Kraków");
        entity.setDescription("Extra Cinema");
        entity.setTelephone("600900800");
        entity.setEmail("bonarka_cinema@cinema.pl");
        entity.setCinema(cinemaEntity);
        return entity;
    }

    public static CinemaFacilityEntity cinemaCityGaleriaKazimierz() {
        final CinemaFacilityEntity entity = new CinemaFacilityEntity();
        entity.setId(2L);
        entity.setName("Cinema City Galeria Kazimierz");
        entity.setAddress("Podgórska 34, 31-536 Kraków");
        entity.setDescription("Fantastic Cinema");
        entity.setTelephone("200300400");
        entity.setEmail("Kazimierz_cinema@cinema.pl");

        return entity;
    }
}

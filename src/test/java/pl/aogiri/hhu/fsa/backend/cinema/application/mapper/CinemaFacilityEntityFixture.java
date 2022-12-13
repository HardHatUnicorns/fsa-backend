package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

public class CinemaFacilityEntityFixture {
    public static CinemaFacilityEntity cinemaCityBonarka(){
        final Long id = 1L;
        final String name = "Cinema City Bonarka";
        final String address = "Henryka Kamieńskiego 11, 30-644 Kraków";

        final CinemaFacilityEntity entity = new CinemaFacilityEntity();
        entity.setAddress(address);
        entity.setId(id);
        entity.setName(name);

        return entity;
    }
}

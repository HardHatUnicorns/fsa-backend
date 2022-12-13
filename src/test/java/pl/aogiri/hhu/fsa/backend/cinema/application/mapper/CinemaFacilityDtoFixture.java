package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;

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
}

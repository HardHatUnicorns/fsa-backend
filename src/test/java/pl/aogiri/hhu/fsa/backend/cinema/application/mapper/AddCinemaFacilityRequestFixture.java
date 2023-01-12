package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.request.AddCinemaFacilityRequest;

public class AddCinemaFacilityRequestFixture {

    public static AddCinemaFacilityRequest cinemaCityBonarka() {
        final var addCinemaFacilityRequest = new AddCinemaFacilityRequest();
        addCinemaFacilityRequest.setName("Cinema City Bonarka");
        addCinemaFacilityRequest.setAddress("Henryka Kamieńskiego 11, 30-644 Kraków");
        addCinemaFacilityRequest.setDescription("Extra Cinema");
        addCinemaFacilityRequest.setEmail("bonarka_cinema@cinema.pl");
        addCinemaFacilityRequest.setTelephone("600900800");
        return addCinemaFacilityRequest;
    }
}

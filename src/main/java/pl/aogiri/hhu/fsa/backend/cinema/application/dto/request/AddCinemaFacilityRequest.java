package pl.aogiri.hhu.fsa.backend.cinema.application.dto.request;

import lombok.Data;

@Data
public class AddCinemaFacilityRequest {

    private String name;
    private String description;
    private String address;
    private String telephone;
    private String email;
}

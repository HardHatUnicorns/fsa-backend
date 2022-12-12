package pl.aogiri.hhu.fsa.backend.cinema.application.dto;

import lombok.Data;

@Data
public class CinemaFacilityDetailsDto {

    private Long id;
    private String name;
    private String address;
    private String description;
    private String telephone;
    private String email;
}

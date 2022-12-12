package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.service.CinemaFacilityService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemaControllerImpl implements CinemaController {
    private final CinemaFacilityService cinemaFacilityService;

    @Override
    public List<CinemaFacilityDto> getCinemaFacilities(long cinemaId) {
        List<CinemaFacilityDto> cinemaFacilityDtoList = cinemaFacilityService.getFacilities(cinemaId);
        return cinemaFacilityDtoList;
    }

    @Override
    public CinemaFacilityDetailsDto getCinemaFacilityDetails(long cinemaId, long facilityId) {
        return CinemaController.super.getCinemaFacilityDetails(cinemaId, facilityId);
    }
}

package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.service.CinemaFacilityService;
import pl.aogiri.hhu.fsa.backend.cinema.application.CinemaService;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CinemaControllerImpl implements CinemaController {
    private final CinemaFacilityService cinemaFacilityService;
    private final CinemaService cinemaService;

    @Override
    public List<CinemaFacilityDto> getCinemaFacilitiesByCinemaId(long cinemaId) {
        return cinemaFacilityService.getCinemaFacilitiesByCinemaId(cinemaId);
    }

    @Override
    public CinemaFacilityDetailsDto getCinemaFacilityDetails(long cinemaId, long facilityId) {
        return cinemaFacilityService.getCinemaFacilitiesDetailsByCinemaId(cinemaId, facilityId);
    }

    @Override
    public List<CinemaDto> getCinemas() {
        return cinemaService.getAllCinemas();
    }
}

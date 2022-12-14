package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.service.CinemaFacilityService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CinemaControllerImpl implements CinemaController {
    private final CinemaFacilityService cinemaFacilityService;

    @Override
    public List<CinemaFacilityDto> getCinemaFacilitiesByCinemaId(long cinemaId) {
        return cinemaFacilityService.getCinemaFacilitiesByCinemaId(cinemaId);
    }
}

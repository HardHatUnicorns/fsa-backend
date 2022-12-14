package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.cinema.application.CinemaService;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CinemaControllerImpl implements CinemaController {

    private final CinemaService cinemaService;

    @Override
    public List<CinemaDto> getCinemas() {
        return cinemaService.getAllCinemas();
    }
}

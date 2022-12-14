package pl.aogiri.hhu.fsa.backend.genre.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.genre.application.GenreService;
import pl.aogiri.hhu.fsa.backend.genre.application.dto.GenreDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GenreControllerImpl implements GenreController {
    private final GenreService genreService;

    @Override
    public List<GenreDto> getGenres() {
        return genreService.getAllGenres();
    }
}

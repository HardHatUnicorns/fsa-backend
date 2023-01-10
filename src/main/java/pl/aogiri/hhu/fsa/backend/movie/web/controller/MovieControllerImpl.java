package pl.aogiri.hhu.fsa.backend.movie.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.movie.application.MovieService;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.request.AddMovieRequest;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieFilterDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieControllerImpl implements MovieController {
    private final MovieService movieService;

    @Override
    public List<MovieDto> getMovies(MovieFilterDto criteria) {
        return movieService.getMovies(criteria);
    }

    @Override
    public MovieDetailsDto getMovieDetails(long movieId) {
        return movieService.getMovieDetails(movieId);
    }

    @Override
    public MovieEntity addMovie(AddMovieRequest addMovieRequest) {
        return movieService.addMovie(addMovieRequest);
    }
}

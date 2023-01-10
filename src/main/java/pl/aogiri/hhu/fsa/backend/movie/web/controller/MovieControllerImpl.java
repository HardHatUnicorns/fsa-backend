package pl.aogiri.hhu.fsa.backend.movie.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.movie.application.MovieService;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.AddedMovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieControllerImpl implements MovieController {
    private final MovieService movieService;

    @Override
    public List<MovieDto> getMovies() {
        return movieService.getAllMovies();
    }

    @Override
    public MovieDetailsDto getMovieDetails(long movieId) {
        return movieService.getMovieDetails(movieId);
    }

    @Override
    public ResponseEntity<?> addMovie(AddedMovieDto addedMovieDto) {
        final var isMovieAdded = movieService.addMovie(addedMovieDto);
        return isMovieAdded ?
                ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.unprocessableEntity().build();
    }
}

package pl.aogiri.hhu.fsa.backend.movie.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;

import java.util.List;

@Tag(
        name = "Movie Controller",
        description = "Provide operations for movie"
)
@RequestMapping("/movies")
public interface MovieController {

    @Operation(summary = "Get all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default List<MovieDto> getMovies() {
        throw new NotImplementedException();
    }

    @Operation(summary = "Get movie details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "/{movieId}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default MovieDetailsDto getMovieDetails(@PathVariable long movieId) {
        throw new NotImplementedException();
    }

    @Operation(summary = "Find movies including provided text in title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "/query",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default List<MovieDto> findMovies(@RequestParam String title) {
        throw new NotImplementedException();
    }
}

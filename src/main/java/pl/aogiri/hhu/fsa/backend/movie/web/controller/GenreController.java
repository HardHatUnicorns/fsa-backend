package pl.aogiri.hhu.fsa.backend.movie.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.GenreDto;

import java.util.List;

@Tag(
        name = "Genre Controller",
        description = "Provide operations for genre"
)
@RequestMapping("/genres")
public interface GenreController {

    @Operation(summary = "Get all available genres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default List<GenreDto> getGenres() {
        throw new NotImplementedException();
    }
}

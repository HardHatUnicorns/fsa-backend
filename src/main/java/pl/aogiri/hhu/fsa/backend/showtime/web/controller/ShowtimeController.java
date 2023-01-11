package pl.aogiri.hhu.fsa.backend.showtime.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;

import java.util.List;

@Tag(
        name = "Showtime Controller",
        description = "Provide operations for showtime"
)
@RequestMapping("/showtimes")
public interface ShowtimeController {

    @Operation(summary = "Get showtime details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found for given id"),
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default ShowtimeDto getShowtimeDetails(@PathVariable long id) {
        throw new NotImplementedException();
    }

    @Operation(summary = "Get all showtimes for cinema facility")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    default List<ShowtimeDto> getShowtimesByCriteria(ShowtimeCriteriaRequest showtimeCriteriaRequest) {
        throw new NotImplementedException();
    }

}

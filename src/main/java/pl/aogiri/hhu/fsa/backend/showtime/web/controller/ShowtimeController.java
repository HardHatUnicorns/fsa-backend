package pl.aogiri.hhu.fsa.backend.showtime.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.request.AddShowtimeRequest;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;

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

    @Operation(summary = "Add a showtime")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Showtime added successfully"),
            @ApiResponse(responseCode = "400", description = "Requested data are incorrect"),
            @ApiResponse(responseCode = "500", description = "Error occurred when adding a showtime")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @PreAuthorize("hasRole('SHOWTIME_ADD')")
    default ShowtimeEntity addShowtime(@RequestBody AddShowtimeRequest addShowtimeRequest) {
        throw new NotImplementedException();
    }

}

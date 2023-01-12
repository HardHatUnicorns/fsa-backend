package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.request.AddCinemaRequest;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;

import java.util.List;

@Tag(
        name = "Cinema Controller",
        description = "Provide operations for cinema"
)
@RequestMapping("/cinemas")
public interface CinemaController {

    @Operation(summary = "Get all cinemas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default List<CinemaDto> getCinemas() {
        throw new NotImplementedException();
    }

    @Operation(summary = "Get cinema details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Cinema not found")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "/{cinemaId}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default CinemaDetailsDto getCinemaDetails(@PathVariable long cinemaId) {
        throw new NotImplementedException();
    }

    @Operation(summary = "Get cinema facilities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Cinema not found")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "/{cinemaId}/facilities",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default List<CinemaFacilityDto> getCinemaFacilitiesByCinemaId(@PathVariable long cinemaId) {
        throw new NotImplementedException();
    }

    @Operation(summary = "Get cinema facility details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Cinema or facility not found")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "/{cinemaId}/facilities/{facilityId}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default CinemaFacilityDetailsDto getCinemaFacilityDetails(
            @PathVariable long cinemaId, @PathVariable long facilityId
    ) {
        throw new NotImplementedException();
    }

    @Operation(summary = "Add a cinema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cinema added successfully"),
            @ApiResponse(responseCode = "400", description = "Requested data are incorrect"),
            @ApiResponse(responseCode = "500", description = "Error occurred when adding a cinema")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @PreAuthorize("hasRole('CINEMA_ADD')")
    default CinemaEntity addCinema(@RequestBody AddCinemaRequest addCinemaRequest) {
        throw new NotImplementedException();
    }
}

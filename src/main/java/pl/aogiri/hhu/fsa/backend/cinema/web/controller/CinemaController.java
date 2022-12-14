package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;

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
    default List<CinemaFacilityDto> getCinemaFacilities(@PathVariable long cinemaId) {
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
}

package pl.aogiri.hhu.fsa.backend.cinema.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaFacilityNotFoundException;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaNotFoundException;
import pl.aogiri.hhu.fsa.backend.common.ErrorResponse;

@ResponseBody
@ControllerAdvice
public class CinemaControllerAdvice {

    @ExceptionHandler(CinemaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse cinemaNotFoundException(CinemaNotFoundException ex) {
        return ErrorResponse.of(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(CinemaFacilityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse cinemaFacilityNotFoundException(CinemaFacilityNotFoundException ex) {
        return ErrorResponse.of(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}

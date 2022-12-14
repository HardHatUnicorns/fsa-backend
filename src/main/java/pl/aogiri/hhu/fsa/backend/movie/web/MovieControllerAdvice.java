package pl.aogiri.hhu.fsa.backend.movie.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.aogiri.hhu.fsa.backend.common.ErrorResponse;
import pl.aogiri.hhu.fsa.backend.movie.exception.MovieNotFoundException;

@ResponseBody
@ControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse movieNotFoundException(MovieNotFoundException ex) {
        return ErrorResponse.of(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}

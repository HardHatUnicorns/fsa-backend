package pl.aogiri.hhu.fsa.backend.showtime.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.aogiri.hhu.fsa.backend.common.ErrorResponse;
import pl.aogiri.hhu.fsa.backend.showtime.exception.ShowtimeNotFoundException;

@ResponseBody
@ControllerAdvice
public class ShowtimeControllerAdvice {

    @ExceptionHandler(ShowtimeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse showtimeNotFoundException(ShowtimeNotFoundException ex) {
        return ErrorResponse.of(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}

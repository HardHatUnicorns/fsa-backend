package pl.aogiri.hhu.fsa.backend.common;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pl.aogiri.hhu.fsa.backend.common.exception.ApplicationException;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {ApplicationException.class})
    protected ResponseEntity<ApplicationErrorResponse> handleConflict(ApplicationException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new ApplicationErrorResponse(ex, request));
    }

    @ExceptionHandler(value = {NotImplementedException.class})
    protected ResponseEntity<?> handleNotImplemented() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}

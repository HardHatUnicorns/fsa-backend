package pl.aogiri.hhu.fsa.backend.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private int code;
    private String message;
    private LocalDateTime timestamp;

    public static ErrorResponse of(int code, String message) {
        return new ErrorResponse(code, message, LocalDateTime.now());
    }

}

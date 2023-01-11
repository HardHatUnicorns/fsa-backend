package pl.aogiri.hhu.fsa.backend.showtime.exception;

import static java.lang.String.format;

public class ShowtimeNotFoundException extends RuntimeException {

    public ShowtimeNotFoundException(long showtimeId) {
        super(format("Showtime with id %d not found", showtimeId));
    }
}

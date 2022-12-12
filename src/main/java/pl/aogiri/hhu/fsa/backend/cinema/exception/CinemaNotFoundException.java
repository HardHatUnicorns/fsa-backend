package pl.aogiri.hhu.fsa.backend.cinema.exception;

import static java.lang.String.format;

public class CinemaNotFoundException extends RuntimeException {

    public CinemaNotFoundException(long cinemaId) {
        super(format("Cinema with id %d not found", cinemaId));
    }
}

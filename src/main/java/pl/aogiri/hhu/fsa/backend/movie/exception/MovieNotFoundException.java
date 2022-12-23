package pl.aogiri.hhu.fsa.backend.movie.exception;

import static java.lang.String.format;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(long movieId) {
        super(format("Movie with id %d not found", movieId));
    }
}

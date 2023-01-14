package pl.aogiri.hhu.fsa.backend.genre.exception;

public class NotSupportedGenresException extends RuntimeException {

    public NotSupportedGenresException() {
        super("Provided genres are not supported");
    }
}

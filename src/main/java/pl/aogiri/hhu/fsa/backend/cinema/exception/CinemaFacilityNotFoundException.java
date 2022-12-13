package pl.aogiri.hhu.fsa.backend.cinema.exception;

import static java.lang.String.format;

public class CinemaFacilityNotFoundException extends RuntimeException {

    public CinemaFacilityNotFoundException(long cinemaId, long facilityId) {
        super(format("For cinema with id %s, facility with id %d not found", cinemaId, facilityId));
    }
}

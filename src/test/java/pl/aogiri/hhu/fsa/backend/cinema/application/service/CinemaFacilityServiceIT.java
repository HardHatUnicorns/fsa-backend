package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import pl.aogiri.hhu.fsa.backend.common.IntegrationTest;

public class CinemaFacilityServiceIT extends IntegrationTest {

    private final CinemaFacilityService cinemaFacilityService;

    @Autowired
    public CinemaFacilityServiceIT(CinemaFacilityService cinemaFacilityService) {
        this.cinemaFacilityService = cinemaFacilityService;
    }

    @BeforeEach
    public void setUp(){

    }

    public void shouldReturnAllCinemaFacilityForCorrectCinemaId(){

    }
}

package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;

public class CinemaDtoFixture {

    public static CinemaDto cinemaCity() {
        final var cinemaDto = new CinemaDto();
        cinemaDto.setId(1L);
        cinemaDto.setName("Cinema City");
        cinemaDto.setAddress("https://www.cinema-city.pl/");
        return cinemaDto;
    }
}

package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDetailsDto;

public class CinemaDetailsDtoFixture {
    public static CinemaDetailsDto cinemaCity() {
        final var cinemaDto = new CinemaDetailsDto();
        cinemaDto.setName("Cinema City");
        cinemaDto.setUrl("https://www.cinema-city.pl/");
        return cinemaDto;
    }
}

package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.request.AddCinemaRequest;

public class AddCinemaRequestFixture {

    public static AddCinemaRequest cinemaCity() {
        final var addCinemaRequest = new AddCinemaRequest();
        addCinemaRequest.setName("Cinema City");
        addCinemaRequest.setAddress("https://www.cinema-city.pl/");
        return addCinemaRequest;
    }
}

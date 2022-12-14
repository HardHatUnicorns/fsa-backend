package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;

public class CinemaEntityFixture {

    public static CinemaEntity cinemaCity() {
        final var cinemaEntity = new CinemaEntity();
        cinemaEntity.setId(1L);
        cinemaEntity.setName("Cinema City");
        cinemaEntity.setUrl("https://www.cinema-city.pl/");
        return cinemaEntity;
    }
}

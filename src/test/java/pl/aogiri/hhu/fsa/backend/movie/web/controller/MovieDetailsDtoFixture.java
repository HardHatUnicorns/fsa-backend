package pl.aogiri.hhu.fsa.backend.movie.web.controller;


import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;

import java.math.BigDecimal;
import java.util.List;


class MovieDetailsDtoFixture {

    public static MovieDetailsDto theIncredibles() {
        final var movieDetailsDto = new MovieDetailsDto();
        movieDetailsDto.setTitle("The Incredibles");
        movieDetailsDto.setDescription("The Incredibles is a 2004 American computer-animated superhero film written and directed by Brad Bird. The film is set in an alternate version of the 1960s, where superheroes are forced to live in secrecy due to public backlash. The story follows Bob Parr (Mr. Incredible), a superhero who is forced to live a normal life as a suburban insurance claims adjuster. His wife, Helen (Elastigirl), and their three children also have superpowers, but they must keep them hidden to avoid being discovered.");
        movieDetailsDto.setGenres(List.of("Action", "Comedy"));
        movieDetailsDto.setScore(new BigDecimal("8.33"));
        movieDetailsDto.setDuration("115 min");
        movieDetailsDto.setReleaseDate("5 November 2015");
        movieDetailsDto.setProductionCountry("USA");
        movieDetailsDto.setDirector("Brad Bird");
        return movieDetailsDto;
    }
}

package pl.aogiri.hhu.fsa.backend.movie.web.controller;


import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;

import java.math.BigDecimal;
import java.util.List;


public class MovieDtoFixture {

    public static MovieDto theIncredibles() {
        final var movieDto = new MovieDto();
        movieDto.setId(1L);
        movieDto.setTitle("The Incredibles");
        movieDto.setShortDescription("The Incredibles is a 2004 American computer-animated superhero film written and directed by Brad Bird. The film...");
        movieDto.setGenres(List.of("Action", "Comedy"));
        movieDto.setScore(new BigDecimal("8.33"));
        return movieDto;
    }
}
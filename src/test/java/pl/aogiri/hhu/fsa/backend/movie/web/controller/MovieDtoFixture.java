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

    public static MovieDto theShawshankRedemption() {
        final var movieDto = new MovieDto();
        movieDto.setId(2L);
        movieDto.setTitle("The Shawshank Redemption");
        movieDto.setShortDescription("Two imprisoned men bond over a number of years, " +
                "finding solace and eventual redemption through acts of common d...");
        movieDto.setGenres(List.of("Drama"));
        movieDto.setScore(new BigDecimal("8.33"));
        return movieDto;
    }

    public static MovieDto avatarTheWayOfWater() {
        final var movieDto = new MovieDto();
        movieDto.setId(3L);
        movieDto.setTitle("Avatar: The Way of Water");
        movieDto.setShortDescription("Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. " +
                "Once a familiar threat returns...");
        movieDto.setGenres(List.of("Action", "Adventure", "Fantasy", "Sci-Fi"));
        movieDto.setScore(new BigDecimal("8.33"));
        return movieDto;
    }
}

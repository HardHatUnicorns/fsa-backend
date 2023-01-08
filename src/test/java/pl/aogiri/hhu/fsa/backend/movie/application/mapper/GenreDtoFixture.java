package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import pl.aogiri.hhu.fsa.backend.movie.application.dto.GenreDto;

public class GenreDtoFixture {

    public static GenreDto action() {
        final var genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Action");
        return genreDto;
    }

    public static GenreDto comedy() {
        final var genreDto = new GenreDto();
        genreDto.setId(2L);
        genreDto.setName("Comedy");
        return genreDto;
    }
}

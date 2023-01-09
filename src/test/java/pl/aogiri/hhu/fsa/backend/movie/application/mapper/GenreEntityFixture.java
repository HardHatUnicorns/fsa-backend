package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import pl.aogiri.hhu.fsa.backend.movie.domain.entity.GenreEntity;

public class GenreEntityFixture {

    public static GenreEntity action() {
        final var genreEntity = new GenreEntity();
        genreEntity.setId(1L);
        genreEntity.setName("Action");
        return genreEntity;
    }

    public static GenreEntity comedy() {
        final var genreEntity = new GenreEntity();
        genreEntity.setId(2L);
        genreEntity.setName("Comedy");
        return genreEntity;
    }

    public static GenreEntity drama() {
        final var genreEntity = new GenreEntity();
        genreEntity.setId(3L);
        genreEntity.setName("Drama");
        return genreEntity;
    }
}

package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import lombok.RequiredArgsConstructor;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.AddedMovieDto;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.GenreRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
public class AddedMovieMapper {

    private static GenreRepository genreRepository;

    public static MovieEntity toEntity(AddedMovieDto addedMovieDto) {
        final var movieEntity = new MovieEntity();
        movieEntity.setTitle(addedMovieDto.getTitle());
        movieEntity.setDescription(addedMovieDto.getDescription());
        movieEntity.setGenres(getGenresByIds(addedMovieDto.getGenres()));
        movieEntity.setDurationInMinutes(addedMovieDto.getDuration());
        movieEntity.setReleaseDate(formatReleaseDate(addedMovieDto.getReleaseDate()));
        movieEntity.setProductionCountry(addedMovieDto.getProductionCountry());
        movieEntity.setDirector(addedMovieDto.getDirector());
        return movieEntity;
    }

    private static List<GenreEntity> getGenresByIds(List<Long> genres) {
        return genreRepository.findAllByIdIn(genres);
    }

    private static LocalDate formatReleaseDate(String releaseDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(releaseDate, formatter);
    }
}

package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.aogiri.hhu.fsa.backend.movie.application.GenreService;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.AddedMovieDto;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class AddedMovieMapper {

    private final GenreService genreService;

    public MovieEntity toEntity(AddedMovieDto addedMovieDto) {
        final var movieEntity = new MovieEntity();
        movieEntity.setTitle(addedMovieDto.getTitle());
        movieEntity.setDescription(addedMovieDto.getDescription());
        movieEntity.setGenres(genreService.getAllGenresForIds(addedMovieDto.getGenres()));
        movieEntity.setDurationInMinutes(addedMovieDto.getDuration());
        movieEntity.setReleaseDate(formatReleaseDate(addedMovieDto.getReleaseDate()));
        movieEntity.setProductionCountry(addedMovieDto.getProductionCountry());
        movieEntity.setDirector(addedMovieDto.getDirector());
        return movieEntity;
    }

    private LocalDate formatReleaseDate(String releaseDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(releaseDate, formatter);
    }
}

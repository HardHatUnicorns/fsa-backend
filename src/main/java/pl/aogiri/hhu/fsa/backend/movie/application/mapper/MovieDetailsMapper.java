package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.ScoreEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class MovieDetailsMapper {

    public static MovieDetailsDto toDto(MovieEntity movieEntity) {
        final var movieDetailsDto = new MovieDetailsDto();
        movieDetailsDto.setTitle(movieEntity.getTitle());
        movieDetailsDto.setDescription(movieEntity.getDescription());
        movieDetailsDto.setScore(averageOfScores(movieEntity.getScores()));
        movieDetailsDto.setGenres(getNamesOfGeneres(movieEntity));
        movieDetailsDto.setDuration(movieEntity.getDurationInMinutes() + " min");
        movieDetailsDto.setReleaseDate(formatReleaseDate(movieEntity.getReleaseDate()));
        movieDetailsDto.setProductionCountry(movieEntity.getProductionCountry());
        movieDetailsDto.setDirector(movieEntity.getDirector());
        return movieDetailsDto;
    }

    private static BigDecimal averageOfScores(List<ScoreEntity> scores) {
        return scores.stream()
                .map(ScoreEntity::getScore)
                .map(bd -> new BigDecimal[]{bd, BigDecimal.ONE})
                .reduce((a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(BigDecimal.ONE)})
                .map(totalWithCount -> totalWithCount[0].divide(totalWithCount[1], 2, RoundingMode.HALF_UP))
                .orElse(BigDecimal.ZERO);
    }

    private static List<String> getNamesOfGeneres(MovieEntity movieEntity) {
        return movieEntity.getGenres().stream().map(GenreEntity::getName).toList();
    }

    private static String formatReleaseDate(LocalDate releaseDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
        return releaseDate.format(formatter);
    }
}

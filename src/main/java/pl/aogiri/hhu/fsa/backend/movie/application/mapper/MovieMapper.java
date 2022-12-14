package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import org.apache.commons.lang3.StringUtils;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.ScoreEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MovieMapper {

    public static MovieDto toDto(MovieEntity movieEntity) {
        final var movieDto = new MovieDto();
        movieDto.setId(movieEntity.getId());
        movieDto.setTitle(movieEntity.getTitle());
        movieDto.setScore(averageOfScores(movieEntity.getScores()));
        movieDto.setShortDescription(StringUtils.abbreviate(movieEntity.getDescription(), 114));
        movieDto.setGenres(getNamesOfGeneres(movieEntity));
        return movieDto;
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
}

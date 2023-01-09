package pl.aogiri.hhu.fsa.backend.movie.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.FilterDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieDetailsMapper;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieMapper;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.ScoreEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;
import pl.aogiri.hhu.fsa.backend.movie.exception.MovieNotFoundException;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    public List<MovieDto> getMovies(FilterDto criteria){
        if(criteria.withNoParam()){
            return getAllMovies();
        } else {
            return getMoviesByCriteria(criteria);
        }
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::toDto)
                .toList();
    }

    public List<MovieDto> getMoviesByCriteria(FilterDto criteria) {
        return movieRepository.findAll().stream()
                .sorted(Comparator.comparing(MovieEntity::getReleaseDate).reversed())
                .filter(x -> criteria.getYear().contains(x.getReleaseDate().getYear())
                || criteria.getCountry().contains(x.getProductionCountry())
                || criteria.getDirector().contains(x.getDirector())
                || x.getGenres().stream().map(GenreEntity::getName)
                        .anyMatch( g -> criteria.getGenre().contains(g))
                || x.getScores().stream().map(ScoreEntity::getScore)
                        .anyMatch( s -> criteria.getScore().contains(s.intValue())))
                .map(MovieMapper::toDto)
                .toList();
}

    public MovieDetailsDto getMovieDetails(Long movieId) {
        return movieRepository.findById(movieId)
                .map(MovieDetailsMapper::toDto)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
    }
}

package pl.aogiri.hhu.fsa.backend.movie.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.genre.application.GenreService;
import pl.aogiri.hhu.fsa.backend.genre.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.genre.domain.repository.GenreRepository;
import pl.aogiri.hhu.fsa.backend.genre.exception.NotSupportedGenresException;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieFilterDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.request.AddMovieRequest;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieDetailsMapper;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieMapper;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.ScoreEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;
import pl.aogiri.hhu.fsa.backend.movie.exception.MovieNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final GenreService genreService;

    public List<MovieDto> getMovies(MovieFilterDto criteria) {
        if (criteria.withNoParam()) {
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

    public List<MovieDto> getMoviesByCriteria(MovieFilterDto criteria) {
        Predicate<MovieEntity> criteriaPredicate = x -> criteria.getYear().contains(x.getReleaseDate().getYear())
                || criteria.getCountry().contains(x.getProductionCountry())
                || criteria.getDirector().contains(x.getDirector())
                || x.getGenres().stream().map(GenreEntity::getName)
                .anyMatch(g -> criteria.getGenre().contains(g))
                || x.getScores().stream().map(ScoreEntity::getScore)
                .anyMatch(s -> criteria.getScore().contains(s.intValue()));
        Predicate<MovieEntity> titlePredicate = m -> m.getTitle().contains(criteria.getTitle());

        return movieRepository.findAll().stream()
                .sorted(Comparator.comparing(MovieEntity::getReleaseDate).reversed())
                .filter(criteria.getTitle().isBlank() ? criteriaPredicate : titlePredicate.or(criteriaPredicate))
                .map(MovieMapper::toDto)
                .toList();
    }

    public MovieDetailsDto getMovieDetails(Long movieId) {
        return movieRepository.findById(movieId)
                .map(MovieDetailsMapper::toDto)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    public MovieEntity addMovie(AddMovieRequest addMovieRequest) {
        final var requestedGenres = addMovieRequest.getGenres();
        final var getGenresById = genreRepository.findAllByIdIn(requestedGenres);

        if (getGenresById.size() != requestedGenres.size()) {
            throw new IllegalArgumentException("Provided genres are incorrect");
        }

        final var movieEntity = MovieMapper.toEntity(addMovieRequest, getGenresById);
        return movieRepository.save(movieEntity);
    }

    public MovieEntity updateMovie(Long movieId, AddMovieRequest addMovieRequest) {
        final var movieEntityToUpdate = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));

        final var requestedGenres = addMovieRequest.getGenres();
        final var getGenresById = genreService.getAllGenresForIds(requestedGenres);

        if (getGenresById.size() != requestedGenres.size()) {
            throw new NotSupportedGenresException();
        }

        final var updatedMovieEntity = MovieMapper.toEntity(addMovieRequest, getGenresById);
        updatedMovieEntity.setId(movieEntityToUpdate.getId());
        updatedMovieEntity.setScores(movieEntityToUpdate.getScores());

        return movieRepository.save(updatedMovieEntity);
    }

    public void deleteMovie(Long movieId) {
        if (!movieRepository.existsById(movieId)) {
            throw new MovieNotFoundException(movieId);
        }

        movieRepository.deleteById(movieId);
    }
}

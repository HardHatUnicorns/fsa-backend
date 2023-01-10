package pl.aogiri.hhu.fsa.backend.movie.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieDetailsMapper;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieMapper;
import pl.aogiri.hhu.fsa.backend.movie.application.request.AddMovieRequest;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.GenreRepository;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;
import pl.aogiri.hhu.fsa.backend.movie.exception.MovieNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::toDto)
                .toList();
    }

    public MovieDetailsDto getMovieDetails(Long movieId) {
        return movieRepository.findById(movieId)
                .map(MovieDetailsMapper::toDto)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    public MovieEntity addMovie(AddMovieRequest addMovieRequest) {
        final var movieEntity = MovieMapper.toEntity(addMovieRequest, genreRepository.findAllByIdIn(addMovieRequest.getGenres()));
        movieRepository.save(movieEntity);
        return movieEntity;
    }
}

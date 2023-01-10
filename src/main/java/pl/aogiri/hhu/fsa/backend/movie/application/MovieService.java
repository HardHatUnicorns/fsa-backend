package pl.aogiri.hhu.fsa.backend.movie.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.AddedMovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.AddedMovieMapper;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieDetailsMapper;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieMapper;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;
import pl.aogiri.hhu.fsa.backend.movie.exception.MovieNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final AddedMovieMapper addedMovieMapper;

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

    public boolean addMovie(AddedMovieDto addedMovieDto) {
        final var movieEntity = addedMovieMapper.toEntity(addedMovieDto);
        movieRepository.save(movieEntity);
        return !ObjectUtils.isEmpty(movieEntity.getId());
    }
}

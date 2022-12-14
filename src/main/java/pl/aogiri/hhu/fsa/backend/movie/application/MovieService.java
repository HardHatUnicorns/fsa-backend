package pl.aogiri.hhu.fsa.backend.movie.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieMapper;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::toDto)
                .toList();
    }
}

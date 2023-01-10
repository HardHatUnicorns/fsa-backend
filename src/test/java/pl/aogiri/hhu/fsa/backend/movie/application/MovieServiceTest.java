package pl.aogiri.hhu.fsa.backend.movie.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieFilterDto;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.AddMovieRequestFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.GenreEntityFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.MovieEntityFixture;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.GenreRepository;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.MovieRepository;
import pl.aogiri.hhu.fsa.backend.movie.exception.MovieNotFoundException;
import pl.aogiri.hhu.fsa.backend.movie.web.controller.MovieDetailsDtoFixture;
import pl.aogiri.hhu.fsa.backend.movie.web.controller.MovieDtoFixture;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    void shouldReturnAllMovies() {
        //given
        final var movies = List.of(MovieEntityFixture.theIncredibles());

        given(movieRepository.findAll()).willReturn(movies);

        //when
        final List<MovieDto> actualAllMovies = movieService.getAllMovies();

        //then
        assertThat(actualAllMovies)
                .hasSize(1)
                .containsExactlyInAnyOrder(
                        MovieDtoFixture.theIncredibles()
                );
    }

    @Test
    void shouldReturnMovieDetailsForCorrectMovieId() {
        //given
        final var movieId = 1L;
        final var movie = MovieEntityFixture.theIncredibles();

        given(movieRepository.findById(movieId)).willReturn(Optional.of(movie));

        //when
        final var actualMovie = movieService.getMovieDetails(movieId);

        //then
        assertThat(actualMovie).isEqualTo(MovieDetailsDtoFixture.theIncredibles());
    }

    @Test
    void shouldThrowMovieNotFoundExceptionForIncorrectMovieIdForGetMovieDetails() {
        //given
        final var movieId = 5L;
        given(movieRepository.findById(movieId)).willReturn(Optional.empty());

        //when/then
        final var exception = assertThrows(
                MovieNotFoundException.class,
                () -> movieService.getMovieDetails(movieId)
        );

        //then
        assertThat(exception.getMessage()).isEqualTo(format("Movie with id %d not found", movieId));
    }

    @Test
    void shouldReturnMoviesByDirectorFilter() {
        //given
        final var movies = List.of(MovieEntityFixture.theIncredibles(), MovieEntityFixture.theShawshankRedemption());
        final var criteria = new MovieFilterDto();
        criteria.setDirector(List.of("Frank Darabont"));

        given(movieRepository.findAll()).willReturn(movies);

        //when
        final List<MovieDto> actualAllMovies = movieService.getMoviesByCriteria(criteria);

        //then
        assertThat(actualAllMovies)
                .hasSize(1)
                .containsExactlyInAnyOrder(
                        MovieDtoFixture.theShawshankRedemption()
                );
    }

    @Test
    void shouldReturnMoviesByYear() {
        //given
        final var movies = List.of(MovieEntityFixture.theIncredibles(), MovieEntityFixture.theShawshankRedemption());
        final var criteria = new MovieFilterDto();
        criteria.setYear(List.of(2004));

        given(movieRepository.findAll()).willReturn(movies);

        //when
        final List<MovieDto> actualAllMovies = movieService.getMoviesByCriteria(criteria);

        //then
        assertThat(actualAllMovies)
                .hasSize(1)
                .containsExactlyInAnyOrder(
                        MovieDtoFixture.theIncredibles()
                );
    }

    @Test
    void shouldReturnMoviesByCountry() {
        //given
        final var movies = List.of(MovieEntityFixture.theIncredibles(),
                MovieEntityFixture.theShawshankRedemption(),
                MovieEntityFixture.avatarTheWayOfWater());
        final var criteria = new MovieFilterDto();
        criteria.setCountry(List.of("USA"));

        given(movieRepository.findAll()).willReturn(movies);

        //when
        final List<MovieDto> actualAllMovies = movieService.getMoviesByCriteria(criteria);

        //then
        assertThat(actualAllMovies)
                .hasSize(3)
                .containsExactly(
                        MovieDtoFixture.avatarTheWayOfWater(),
                        MovieDtoFixture.theIncredibles(),
                        MovieDtoFixture.theShawshankRedemption()
                );
    }

    @Test
    void shouldReturnMoviesByGenres() {
        //given
        final var movies = List.of(MovieEntityFixture.theIncredibles(),
                MovieEntityFixture.theShawshankRedemption(),
                MovieEntityFixture.avatarTheWayOfWater());
        final var criteria = new MovieFilterDto();
        criteria.setGenre(List.of("Comedy", "Fantasy"));

        given(movieRepository.findAll()).willReturn(movies);

        //when
        final List<MovieDto> actualAllMovies = movieService.getMoviesByCriteria(criteria);

        //then
        assertThat(actualAllMovies)
                .hasSize(2)
                .containsExactly(
                        MovieDtoFixture.avatarTheWayOfWater(),
                        MovieDtoFixture.theIncredibles()
                );
    }

    @Test
    void shouldAddNewMovieForCorrectDto() {
        //given
        final var givenMovie = AddMovieRequestFixture.theIncredibles();
        final var expectedMovie = MovieEntityFixture.theIncrediblesWithoutScores();
        final var expectedGenres = List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy());

        given(movieRepository.save(any())).willReturn(expectedMovie);
        given(genreRepository.findAllByIdIn(any())).willReturn(expectedGenres);

        //when
        final var actual = movieService.addMovie(givenMovie);

        //then
        verify(movieRepository).save(expectedMovie);
        assertThat(actual).isEqualTo(expectedMovie);
    }
}

package pl.aogiri.hhu.fsa.backend.movie.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.GenreDto;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.GenreDtoFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.GenreEntityFixture;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.repository.GenreRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreService genreService;

    @Test
    void shouldReturnAllGenres() {
        //given
        final var genres = List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy());

        given(genreRepository.findAll()).willReturn(genres);

        //when
        final List<GenreDto> actualAllGenres = genreService.getAllGenres();

        //then
        assertThat(actualAllGenres)
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        GenreDtoFixture.action(),
                        GenreDtoFixture.comedy()
                );
    }

    @Test
    void shouldReturnAllGenresForIds() {
        //given
        final var genres = List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy());
        final var genresIds = List.of(1L, 2L);

        given(genreRepository.findAllByIdIn(genresIds)).willReturn(genres);

        //when
        final List<GenreEntity> actualAllGenresByIds = genreService.getAllGenresForIds(genresIds);

        //then
        assertThat(actualAllGenresByIds)
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        GenreEntityFixture.action(),
                        GenreEntityFixture.comedy()
                );
    }
}

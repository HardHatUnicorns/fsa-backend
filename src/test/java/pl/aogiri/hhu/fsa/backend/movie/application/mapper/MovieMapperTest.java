package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.movie.web.controller.MovieDtoFixture;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class MovieMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = MovieEntityFixture.theIncredibles();

        //when
        final MovieDto actualDto = MovieMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(MovieDtoFixture.theIncredibles());
    }

    @Test
    public void shouldReturnZeroScoreWhenNoScores() {
        //given
        final var givenEntity = MovieEntityFixture.theIncredibles();
        givenEntity.setScores(List.of());

        //when
        final MovieDto actualDto = MovieMapper.toDto(givenEntity);

        //then
        assertThat(actualDto.getScore()).isZero();
    }

    @Test
    public void shouldSuccessfullyMapDtoToEntityWhenCorrectDtoIsGiven() {
        //given
        final var givenDto = AddMovieRequestFixture.theIncredibles();
        final var givenGenresEntity = List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy());

        //when
        final MovieEntity actualEntity = MovieMapper.toEntity(givenDto, givenGenresEntity);

        //then
        assertThat(actualEntity).isEqualTo(MovieEntityFixture.theIncrediblesWithoutScores());
    }
}

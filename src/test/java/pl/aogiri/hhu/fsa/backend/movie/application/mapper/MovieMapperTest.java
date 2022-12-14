package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;
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
}

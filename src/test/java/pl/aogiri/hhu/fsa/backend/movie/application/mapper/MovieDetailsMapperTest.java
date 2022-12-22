package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovieDetailsMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = MovieEntityFixture.theIncredibles();

        //when
        final MovieDetailsDto actualDto = MovieDetailsMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(MovieDetailsDtoFixture.theIncredibles());
    }
}

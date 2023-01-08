package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.GenreDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenreMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = GenreEntityFixture.action();

        //when
        final GenreDto actualDto = GenreMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(GenreDtoFixture.action());
    }
}

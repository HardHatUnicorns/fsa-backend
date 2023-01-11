package pl.aogiri.hhu.fsa.backend.showtime.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShowtimeMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = ShowtimeEntityFixture.showtimeTheIncrediblesInCinemaCityBonarka();

        //when
        final ShowtimeDto actualDto = ShowtimeMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(ShowtimeDtoFixture.showtimeTheIncrediblesInCinemaCityBonarka());
    }
}

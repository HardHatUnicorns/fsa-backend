package pl.aogiri.hhu.fsa.backend.showtime.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.mapper.ShowtimeDtoFixture;
import pl.aogiri.hhu.fsa.backend.showtime.application.mapper.ShowtimeEntityFixture;
import pl.aogiri.hhu.fsa.backend.showtime.domain.repository.ShowtimeRepository;
import pl.aogiri.hhu.fsa.backend.showtime.exception.ShowtimeNotFoundException;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ShowtimeServiceTest {

    @Mock
    private ShowtimeRepository showtimeRepository;

    @InjectMocks
    private ShowtimeService showtimeService;

    @Test
    void shouldReturnShowtimeDetailsForCorrectMovieId() {
        //given
        final var showtimeId = 1L;
        final var showtime = ShowtimeEntityFixture.showtimeTheIncrediblesInCinemaCityBonarka();

        given(showtimeRepository.findById(showtimeId)).willReturn(Optional.of(showtime));

        //when
        final var actualShowtime = showtimeService.getShowtimeDetails(showtimeId);

        //then
        assertThat(actualShowtime).isEqualTo(ShowtimeDtoFixture.showtimeTheIncrediblesInCinemaCityBonarka());
    }

    @Test
    void shouldThrowShowtimeNotFoundExceptionForIncorrectShowtimeIdForGetShowtimeDetails() {
        //given
        final var showtimeId = 5L;
        given(showtimeRepository.findById(showtimeId)).willReturn(Optional.empty());

        //when/then
        final var exception = assertThrows(
                ShowtimeNotFoundException.class,
                () -> showtimeService.getShowtimeDetails(showtimeId)
        );

        //then
        assertThat(exception.getMessage()).isEqualTo(format("Showtime with id %d not found", showtimeId));
    }

    @Test
    void shouldReturnAllShowtime() {
        //given
        final var showtimes = List.of(
                ShowtimeEntityFixture.showtimeTheIncrediblesInCinemaCityBonarka(),
                ShowtimeEntityFixture.showtimeAvatarTheWayOfWaterInCinemaCityBonarka());
        final var criteria = new ShowtimeCriteriaRequest(null, null, null, null, null, null, null);

        given(showtimeRepository.findAll()).willReturn(showtimes);

        //when
        final var actualShowtime = showtimeService.getShowtimes(criteria);

        //then
        assertThat(actualShowtime)
                .hasSize(2)
                .contains(
                        ShowtimeDtoFixture.showtimeTheIncrediblesInCinemaCityBonarka(),
                        ShowtimeDtoFixture.showtimeAvatarTheWayOfWaterInCinemaCityBonarka());
    }
}

package pl.aogiri.hhu.fsa.backend.cinema.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaEntityFixture;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.web.controller.CinemaDtoFixture;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CinemaServiceTest {

    @Mock
    private CinemaRepository cinemaRepository;

    @InjectMocks
    private CinemaService cinemaService;

    @Test
    void shouldReturnAllCinemas() {
        // given
        final var cinemas = List.of(CinemaEntityFixture.cinemaCity());
        given(cinemaRepository.findAll()).willReturn(cinemas);

        // when
        final List<CinemaDto> actualCinema = cinemaService.getAllCinemas();

        // then
        assertThat(actualCinema)
                .hasSize(1)
                .containsExactlyInAnyOrder(CinemaDtoFixture.cinemaCity());

    }
}

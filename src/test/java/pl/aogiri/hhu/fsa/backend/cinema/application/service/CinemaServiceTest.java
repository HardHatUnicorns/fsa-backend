package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaEntityFixture;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaNotFoundException;
import pl.aogiri.hhu.fsa.backend.cinema.web.controller.CinemaDetailsDtoFixture;
import pl.aogiri.hhu.fsa.backend.cinema.web.controller.CinemaDtoFixture;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void shouldReturnCinemaDetailsForCorrectId() {
        // given
        final var givenCinemaId = 1L;
        final var cinemaEntity = CinemaEntityFixture.cinemaCity();
        given(cinemaRepository.findById(givenCinemaId)).willReturn(Optional.of(cinemaEntity));

        // when
        final var actualDto = cinemaService.getCinemaDetails(givenCinemaId);

        // then
        assertThat(actualDto)
                .isEqualTo(CinemaDetailsDtoFixture.cinemaCity());
    }

    @Test
    void shouldThrowCinemaNotfoundExceptionForIncorrectCinemaIdForGetCinemaDetailsMethod() {
        //given
        final var givenCinemaId = 1L;
        given(cinemaRepository.findById(givenCinemaId)).willReturn(Optional.empty());

        //when/then
        final var exception = assertThrows(
                CinemaNotFoundException.class,
                () -> cinemaService.getCinemaDetails(givenCinemaId)
        );

        assertThat(exception.getMessage()).isEqualTo(format("Cinema with id %d not found", givenCinemaId));
    }
}

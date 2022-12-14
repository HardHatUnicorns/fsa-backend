package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityDtoFixture;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityEntityFixture;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaFacilityRepository;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaNotFoundException;

import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CinemaFacilityServiceTest {

    @Mock
    private CinemaRepository cinemaRepository;

    @Mock
    private CinemaFacilityRepository cinemaFacilityRepository;

    @InjectMocks
    private CinemaFacilityService cinemaFacilityService;

    @Test
    void shouldReturnAllFacilitiesForCorrectCinemaId() {
        //given
        final var givenCinemaId = 1L;
        final var facilities = List.of(
                CinemaFacilityEntityFixture.cinemaCityGaleriaKazimierz(),
                CinemaFacilityEntityFixture.cinemaCityBonarka()
        );

        given(cinemaFacilityRepository.findAllByCinemaId(givenCinemaId)).willReturn(facilities);
        given(cinemaRepository.existsById(givenCinemaId)).willReturn(true);

        //when
        final var actualFacilities = cinemaFacilityService.getCinemaFacilitiesByCinemaId(givenCinemaId);

        //then
        assertThat(actualFacilities)
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        CinemaFacilityDtoFixture.cinemaCityGaleriaKazimierz(),
                        CinemaFacilityDtoFixture.cinemaCityBonarka()
                );
    }

    @Test
    void shouldThrowCinemaNotfoundExceptionForIncorrectCinemaId() {
        //given
        final var givenCinemaId = 1L;
        given(cinemaRepository.existsById(givenCinemaId)).willReturn(false);

        //when/then
        final var exception = assertThrows(
                CinemaNotFoundException.class,
                () -> cinemaFacilityService.getCinemaFacilitiesByCinemaId(givenCinemaId)
        );

        assertThat(exception.getMessage()).isEqualTo(format("Cinema with id %d not found", givenCinemaId));
    }
}

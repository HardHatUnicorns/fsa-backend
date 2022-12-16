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
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaFacilityNotFoundException;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaNotFoundException;

import java.util.List;
import java.util.Optional;

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
    void shouldReturnFacilitiesDetailsForCorrectCinemaId() {
        //given
        final var givenCinemaId = 1L;
        final var givenFacilityId = 1L;
        final var facility = CinemaFacilityEntityFixture.cinemaCityBonarka();

        given(cinemaFacilityRepository.findById(givenFacilityId)).willReturn(Optional.of(facility));
        given(cinemaRepository.existsById(givenCinemaId)).willReturn(true);

        //when
        final var actualFacilities = cinemaFacilityService.getCinemaFacilitiesDetailsByCinemaId(givenCinemaId, givenFacilityId);

        //then
        assertThat(actualFacilities).isEqualTo(actualFacilities);
    }

    @Test
    void shouldThrowCinemaNotfoundExceptionForIncorrectCinemaIdForGetCinemaFacilities() {
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

    @Test
    void shouldThrowCinemaNotfoundExceptionForIncorrectCinemaIdForGetCinemaFacilitiesDetails() {
        //given
        final var givenCinemaId = 1L;
        final var givenFacilityId = 1L;
        given(cinemaRepository.existsById(givenCinemaId)).willReturn(false);

        //when/then
        final var exception = assertThrows(
                CinemaNotFoundException.class,
                () -> cinemaFacilityService.getCinemaFacilitiesDetailsByCinemaId(givenCinemaId, givenFacilityId)
        );

        assertThat(exception.getMessage()).isEqualTo(format("Cinema with id %d not found", givenCinemaId));
    }

    @Test
    void shouldThrowCinemaFacilityNotfoundExceptionForIncorrectCinemaFacilityIdForGetCinemaFacilitiesDetails() {
        //given
        final var givenCinemaId = 1L;
        final var givenFacilityId = 999L;
        given(cinemaRepository.existsById(givenCinemaId)).willReturn(true);
        given(cinemaFacilityRepository.findById(givenFacilityId)).willReturn(Optional.empty());

        //when/then
        final var exception = assertThrows(
                CinemaFacilityNotFoundException.class,
                () -> cinemaFacilityService.getCinemaFacilitiesDetailsByCinemaId(givenCinemaId, givenFacilityId)
        );

        assertThat(exception.getMessage()).
                isEqualTo(format("For cinema with id %s, facility with id %d not found", givenCinemaId, givenFacilityId));
    }
}

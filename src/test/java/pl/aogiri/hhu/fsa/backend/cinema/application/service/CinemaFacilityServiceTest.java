package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
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
import static org.mockito.Mockito.mock;

class CinemaFacilityServiceTest {

    private CinemaRepository cinemaRepository;
    private CinemaFacilityRepository cinemaFacilityRepository;
    private CinemaFacilityService cinemaFacilityService;

    @Before
    public void setUp() {
        cinemaRepository = mock(CinemaRepository.class);
        cinemaFacilityRepository = mock(CinemaFacilityRepository.class);
        cinemaFacilityService = new CinemaFacilityService(cinemaFacilityRepository, cinemaRepository);
    }

    @Test
    void shouldReturnAllFacilitiesForCorrectCinemaId() {
        //given
        Long givenCinemaId = 1L;
        given(cinemaFacilityRepository.findAllByCinemaId(givenCinemaId))
                .willReturn(List.of(CinemaFacilityEntityFixture.cinemaCityGaleriaKazimierz(),
                        CinemaFacilityEntityFixture.cinemaCityBonarka()));
        given(cinemaRepository.existsById(givenCinemaId)).willReturn(true);
        //when
        List<CinemaFacilityDto> facilities = cinemaFacilityService.getFacilities(givenCinemaId);

        //then
        assertThat(facilities).
                isEqualTo(List.of(CinemaFacilityDtoFixture.cinemaCityGaleriaKazimierz(),
                        CinemaFacilityDtoFixture.cinemaCityBonarka()));
    }

    @Test
    void shouldThrowCinemaNotfoundExceptionForIncorrectCinemaId() {
        //given
        Long givenCinemaId = 999L;
        given(cinemaRepository.existsById(givenCinemaId)).willReturn(false);
        //when
        CinemaNotFoundException exception = assertThrows(CinemaNotFoundException.class,
                () -> cinemaFacilityService.getFacilities(givenCinemaId));

        //then
        assertThat(format("Cinema with id %d not found", givenCinemaId)).isEqualTo(exception.getMessage());
    }
}
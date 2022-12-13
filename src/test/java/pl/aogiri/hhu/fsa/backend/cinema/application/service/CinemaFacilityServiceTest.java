package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityDtoFixture;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityEntityFixture;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaFacilityRepository;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaNotFoundException;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CinemaFacilityServiceTest {

    private static CinemaRepository cinemaRepository;
    private static CinemaFacilityRepository cinemaFacilityRepository;
    private static CinemaFacilityService cinemaFacilityService;

    @BeforeAll
    public static void beforeAll(){
        cinemaRepository = mock(CinemaRepository.class);
        cinemaFacilityRepository = mock(CinemaFacilityRepository.class);
        cinemaFacilityService = new CinemaFacilityService(cinemaFacilityRepository, cinemaRepository);
    }

    @Test
    void shouldReturnAllFacilitiesForCorrectCinemaId() {
        //given
        Long givenCinemaId = 1L;
        given(cinemaFacilityRepository.findAllByCinemaId(givenCinemaId))
                .willReturn(CinemaFacilityEntityFixture.listOfFacility());
        given(cinemaRepository.findById(givenCinemaId)).willReturn(Optional.of(new CinemaEntity()));
        //when
        List<CinemaFacilityDto> facilities = cinemaFacilityService.getFacilities(givenCinemaId);

        //then
        assertEquals(CinemaFacilityDtoFixture.listOfFacility(), facilities);
    }

    @Test
    void shouldThrowCinemaNotfoundExceptionForIncorrectCinemaId() {
        //given
        Long givenCinemaId = 999L;
        given(cinemaRepository.findById(givenCinemaId)).willReturn(Optional.empty());
        //when
        CinemaNotFoundException exception = assertThrows(CinemaNotFoundException.class,
                () -> cinemaFacilityService.getFacilities(givenCinemaId));

        //then
        assertEquals(format("Cinema with id %d not found", givenCinemaId), exception.getMessage());
    }
}
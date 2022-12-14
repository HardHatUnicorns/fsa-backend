package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityDetailsMapper;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityMapper;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaFacilityRepository;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaFacilityNotFoundException;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CinemaFacilityService {
    private final CinemaFacilityRepository cinemaFacilityRepository;
    private final CinemaRepository cinemaRepository;

    public List<CinemaFacilityDto> getCinemaFacilitiesByCinemaId(Long cinemaId) {
        if (!cinemaRepository.existsById(cinemaId)) {
            throw new CinemaNotFoundException(cinemaId);
        }

        return cinemaFacilityRepository.findAllByCinemaId(cinemaId)
                .stream()
                .map(CinemaFacilityMapper::toDto)
                .toList();
    }

    public CinemaFacilityDetailsDto getCinemaFacilitiesDetailsByCinemaId(Long cinemaId, Long facilityId) {
        if (!cinemaRepository.existsById(cinemaId)) {
            throw new CinemaNotFoundException(cinemaId);
        }

        return cinemaFacilityRepository.findById(facilityId)
                .map(CinemaFacilityDetailsMapper::toDto)
                .orElseThrow(() -> new CinemaFacilityNotFoundException(cinemaId, facilityId));
    }
}

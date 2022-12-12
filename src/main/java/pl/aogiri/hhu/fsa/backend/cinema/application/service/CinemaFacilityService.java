package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityMapper;

@RequiredArgsConstructor
@Service
public class CinemaFacilityService {
    private final CinemaFacilityMapper cinemaFacilityMapper;


}

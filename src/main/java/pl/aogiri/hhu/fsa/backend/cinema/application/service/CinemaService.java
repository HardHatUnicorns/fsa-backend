package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaDetailsMapper;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaMapper;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public List<CinemaDto> getAllCinemas() {
        return cinemaRepository.findAll().stream()
                .map(CinemaMapper::toDto)
                .toList();
    }

    public CinemaDetailsDto getCinemaDetails(long cinemaId){
        return cinemaRepository.findById(cinemaId)
                .map(CinemaDetailsMapper::toDto)
                .orElseThrow(() -> new CinemaNotFoundException(cinemaId));
    }
}

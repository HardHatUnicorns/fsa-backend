package pl.aogiri.hhu.fsa.backend.showtime.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.mapper.ShowtimeMapper;
import pl.aogiri.hhu.fsa.backend.showtime.domain.repository.ShowtimeRepository;
import pl.aogiri.hhu.fsa.backend.showtime.exception.ShowtimeNotFoundException;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;

    public ShowtimeDto getShowtimeDetails(Long showtimeId) {
        return showtimeRepository.findById(showtimeId)
                .map(ShowtimeMapper::toDto)
                .orElseThrow(() -> new ShowtimeNotFoundException(showtimeId));
    }
    public List<ShowtimeDto> getShowtimes(ShowtimeCriteriaRequest showtimeCriteriaRequest){
        return showtimeRepository.findAll()
                .stream()
                .map(ShowtimeMapper::toDto)
                .toList();
    }
}

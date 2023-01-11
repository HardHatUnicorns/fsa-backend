package pl.aogiri.hhu.fsa.backend.showtime.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.mapper.ShowtimeMapper;
import pl.aogiri.hhu.fsa.backend.showtime.domain.repository.ShowtimeRepository;
import pl.aogiri.hhu.fsa.backend.showtime.exception.ShowtimeNotFoundException;

@RequiredArgsConstructor
@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    public ShowtimeDto getShowtimeDetails(Long showtimeId) {
        return showtimeRepository.findById(showtimeId)
                .map(ShowtimeMapper::toDto)
                .orElseThrow(() -> new ShowtimeNotFoundException(showtimeId));
    }
}

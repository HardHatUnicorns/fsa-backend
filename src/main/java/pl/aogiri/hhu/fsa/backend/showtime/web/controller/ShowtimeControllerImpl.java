package pl.aogiri.hhu.fsa.backend.showtime.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.showtime.application.ShowtimeService;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;

@RequiredArgsConstructor
@RestController
public class ShowtimeControllerImpl implements ShowtimeController {
    private final ShowtimeService showtimeService;

    @Override
    public ShowtimeDto getShowtimeDetails(long showtimeId) {
        return showtimeService.getShowtimeDetails(showtimeId);
    }
}

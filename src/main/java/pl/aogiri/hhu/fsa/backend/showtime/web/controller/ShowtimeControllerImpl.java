package pl.aogiri.hhu.fsa.backend.showtime.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.showtime.application.ShowtimeService;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.request.AddShowtimeRequest;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;

@RequiredArgsConstructor
@RestController
public class ShowtimeControllerImpl implements ShowtimeController {
    private final ShowtimeService showtimeService;

    @Override
    public ShowtimeDto getShowtimeDetails(long showtimeId) {
        return showtimeService.getShowtimeDetails(showtimeId);
    }

    @Override
    public ShowtimeEntity addShowtime(AddShowtimeRequest addShowtimeRequest) {
        return showtimeService.addShowtime(addShowtimeRequest);
    }
}

package pl.aogiri.hhu.fsa.backend.showtime.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.showtime.application.ShowtimeService;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeCriteriaRequest;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.request.AddShowtimeRequest;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShowtimeControllerImpl implements ShowtimeController {
    private final ShowtimeService showtimeService;

    @Override
    public ShowtimeDto getShowtimeDetails(long showtimeId) {
        return showtimeService.getShowtimeDetails(showtimeId);
    }

    @Override
    public List<ShowtimeDto> getShowtimesByCriteria(ShowtimeCriteriaRequest showtimeCriteriaRequest) {
        return showtimeService.getShowtimesByCriteria(showtimeCriteriaRequest);
    }
    
    @Override
    public ShowtimeEntity addShowtime(AddShowtimeRequest addShowtimeRequest) {
        return showtimeService.addShowtime(addShowtimeRequest);
    }
}

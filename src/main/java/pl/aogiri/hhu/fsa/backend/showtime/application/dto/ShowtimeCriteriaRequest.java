package pl.aogiri.hhu.fsa.backend.showtime.application.dto;

import lombok.Value;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeTextSourceType;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeVideoType;

import java.time.LocalDate;

@Value
public class ShowtimeCriteriaRequest {
    Long movieId;
    Long facilityId;
    LocalDate fromDate;
    LocalDate toDate;
    ShowtimeVideoType showtimeVideoType;
    ShowtimeTextSourceType showtimeTextSourceType;
    String language;
}

package pl.aogiri.hhu.fsa.backend.showtime.application.dto;

import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeTextSourceType;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeVideoType;

import java.time.LocalDateTime;

@Value
public class ShowtimeCriteriaRequest {
    Long movieId;
    Long facilityId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime fromDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime toDate;
    ShowtimeVideoType showtimeVideoType;
    ShowtimeTextSourceType showtimeTextSourceType;
    String language;
}

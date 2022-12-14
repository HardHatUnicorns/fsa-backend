package pl.aogiri.hhu.fsa.backend.movie.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MovieDetailsDto {

    private String title;
    private String description;
    private BigDecimal score;
    private List<String> genres;
    private String duration;
    private String releaseDate;
    private String productionCountry;
    private String director;
}

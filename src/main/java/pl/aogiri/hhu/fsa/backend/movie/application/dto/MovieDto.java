package pl.aogiri.hhu.fsa.backend.movie.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MovieDto {

    private Long id;
    private String title;
    private BigDecimal score;
    private String shortDescription;
    private List<String> genres;
}

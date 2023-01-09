package pl.aogiri.hhu.fsa.backend.movie.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddedMovieDto {

    private String title;
    private String description;
    private List<Long> genres;
    private int duration;
    private String releaseDate;
    private String productionCountry;
    private String director;
}

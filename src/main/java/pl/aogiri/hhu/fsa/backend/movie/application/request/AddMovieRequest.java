package pl.aogiri.hhu.fsa.backend.movie.application.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AddMovieRequest {

    private String title;
    private String description;
    private List<Long> genres;
    private int duration;
    private LocalDate releaseDate;
    private String productionCountry;
    private String director;
}

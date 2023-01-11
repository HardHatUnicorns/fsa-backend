package pl.aogiri.hhu.fsa.backend.movie.application.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class MovieFilterDto {
    private String title = "";
    private List<String> genre = new ArrayList<>();
    private List<Integer> score = new ArrayList<>();
    private List<Integer> year = new ArrayList<>();
    private List<String> country = new ArrayList<>();
    private List<String> director = new ArrayList<>();

    public boolean withNoParam() {
        return Stream.of(genre, score, year, country, director).allMatch(List::isEmpty) && title.isEmpty();
    }
}

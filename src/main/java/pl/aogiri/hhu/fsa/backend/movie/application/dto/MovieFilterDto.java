package pl.aogiri.hhu.fsa.backend.movie.application.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class MovieFilterDto {
    List<String> genre = new ArrayList<>();
    List<Integer> score = new ArrayList<>();
    List<Integer> year = new ArrayList<>();
    List<String> country = new ArrayList<>();
    List<String> director = new ArrayList<>();

    public boolean withNoParam() {
        return Stream.of(genre, score, year, country, director).allMatch(List::isEmpty);
    }
}

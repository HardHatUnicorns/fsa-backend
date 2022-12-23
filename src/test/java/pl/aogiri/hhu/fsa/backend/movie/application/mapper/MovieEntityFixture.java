package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;

import java.time.LocalDate;
import java.util.List;

public class MovieEntityFixture {

    public static MovieEntity theIncredibles() {
        final var movieEntity = new MovieEntity();
        movieEntity.setId(1L);
        movieEntity.setTitle("The Incredibles");
        movieEntity.setDescription("The Incredibles is a 2004 American computer-animated superhero film written and directed by Brad Bird. The film is set in an alternate version of the 1960s, where superheroes are forced to live in secrecy due to public backlash. The story follows Bob Parr (Mr. Incredible), a superhero who is forced to live a normal life as a suburban insurance claims adjuster. His wife, Helen (Elastigirl), and their three children also have superpowers, but they must keep them hidden to avoid being discovered.");
        movieEntity.setScores(List.of(
                ScoreEntityFixture.johnDon_theIncredibles_score("8"),
                ScoreEntityFixture.janeDoe_theIncredibles_score("9"),
                ScoreEntityFixture.johnSmith_theIncredibles_score("8")
        ));
        movieEntity.setGenres(List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy()));
        movieEntity.setDurationInMinutes(115);
        movieEntity.setReleaseDate(LocalDate.parse("2004-11-05"));
        movieEntity.setProductionCountry("USA");
        movieEntity.setDirector("Brad Bird");
        return movieEntity;
    }
}

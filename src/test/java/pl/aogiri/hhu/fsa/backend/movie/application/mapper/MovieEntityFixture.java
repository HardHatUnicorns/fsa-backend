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

    public static MovieEntity theShawshankRedemption() {
        final var movieEntity = new MovieEntity();
        movieEntity.setId(2L);
        movieEntity.setTitle("The Shawshank Redemption");
        movieEntity.setDescription("Two imprisoned men bond over a number of years, " +
                "finding solace and eventual redemption through acts of common decency.");
        movieEntity.setScores(List.of(
                ScoreEntityFixture.johnDon_theShawshankRedemption_score("8"),
                ScoreEntityFixture.janeDoe_theShawshankRedemption_score("9"),
                ScoreEntityFixture.johnSmith_theShawshankRedemption_score("8")
        ));
        movieEntity.setGenres(List.of(GenreEntityFixture.drama()));
        movieEntity.setDurationInMinutes(142);
        movieEntity.setReleaseDate(LocalDate.parse("1994-09-10"));
        movieEntity.setProductionCountry("USA");
        movieEntity.setDirector("Frank Darabont");
        return movieEntity;
    }

    public static MovieEntity avatarTheWayOfWater() {
        final var movieEntity = new MovieEntity();
        movieEntity.setId(3L);
        movieEntity.setTitle("Avatar: The Way of Water");
        movieEntity.setDescription("Jake Sully lives with his newfound family formed on the extrasolar moon Pandora." +
                " Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri " +
                "and the army of the Na'vi race to protect their home.");
        movieEntity.setScores(List.of(
                ScoreEntityFixture.johnDon_theShawshankRedemption_score("8"),
                ScoreEntityFixture.janeDoe_theShawshankRedemption_score("9"),
                ScoreEntityFixture.johnSmith_theShawshankRedemption_score("8")
        ));
        movieEntity.setGenres(List.of(GenreEntityFixture.action(), GenreEntityFixture.adventure(),
                GenreEntityFixture.fantasy(), GenreEntityFixture.sciFi()));
        movieEntity.setDurationInMinutes(192);
        movieEntity.setReleaseDate(LocalDate.parse("2022-12-12"));
        movieEntity.setProductionCountry("USA");
        movieEntity.setDirector("James Cameron");
        return movieEntity;
    }

    public static MovieEntity theIncrediblesWithoutScores() {
        final var movieEntity = new MovieEntity();
        movieEntity.setTitle("The Incredibles");
        movieEntity.setDescription("The Incredibles is a 2004 American computer-animated superhero film written and directed by Brad Bird. The film is set in an alternate version of the 1960s, where superheroes are forced to live in secrecy due to public backlash. The story follows Bob Parr (Mr. Incredible), a superhero who is forced to live a normal life as a suburban insurance claims adjuster. His wife, Helen (Elastigirl), and their three children also have superpowers, but they must keep them hidden to avoid being discovered.");
        movieEntity.setGenres(List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy()));
        movieEntity.setDurationInMinutes(115);
        movieEntity.setReleaseDate(LocalDate.parse("2004-11-05"));
        movieEntity.setProductionCountry("USA");
        movieEntity.setDirector("Brad Bird");
        return movieEntity;
    }
}

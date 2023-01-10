package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import pl.aogiri.hhu.fsa.backend.movie.application.request.AddMovieRequest;

import java.time.LocalDate;
import java.util.List;

public class AddMovieRequestFixture {

    public static AddMovieRequest theIncredibles() {
        final var addMovieDto = new AddMovieRequest();
        addMovieDto.setTitle("The Incredibles");
        addMovieDto.setDescription("The Incredibles is a 2004 American computer-animated superhero film written and directed by Brad Bird. The film is set in an alternate version of the 1960s, where superheroes are forced to live in secrecy due to public backlash. The story follows Bob Parr (Mr. Incredible), a superhero who is forced to live a normal life as a suburban insurance claims adjuster. His wife, Helen (Elastigirl), and their three children also have superpowers, but they must keep them hidden to avoid being discovered.");
        addMovieDto.setGenres(List.of(1L, 2L));
        addMovieDto.setDuration(115);
        addMovieDto.setReleaseDate(LocalDate.parse("2004-11-05"));
        addMovieDto.setProductionCountry("USA");
        addMovieDto.setDirector("Brad Bird");
        return addMovieDto;
    }
}

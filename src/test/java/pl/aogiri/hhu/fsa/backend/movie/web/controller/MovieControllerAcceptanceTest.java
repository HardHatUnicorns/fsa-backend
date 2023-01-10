package pl.aogiri.hhu.fsa.backend.movie.web.controller;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import pl.aogiri.hhu.fsa.backend.common.AcceptanceTest;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDetailsDto;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Sql({
        "classpath:/sql/genre/genres.sql",
        "classpath:/sql/user/users.sql",
        "classpath:/sql/movie/the_incredibles.sql",
})
@Sql(value = "classpath:/sql/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class MovieControllerAcceptanceTest extends AcceptanceTest {

    @Test
    void shouldReturnAllMoviesInDatabase() {
        final var movieDtos = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/movies")
                .then()
                .statusCode(200)
                .extract()
                .body().as(MovieDto[].class);

        assertThat(movieDtos)
                .hasSize(1)
                .contains(MovieDtoFixture.theIncredibles());
    }

    @Test
    void shouldReturnMovieDetails() {
        final var detailsDto = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/movies/1")
                .then()
                .statusCode(200)
                .extract()
                .body().as(MovieDetailsDto.class);

        assertThat(detailsDto).isEqualTo(MovieDetailsDtoFixture.theIncredibles());
    }

    @Test
    void shouldFindMovies() {
        final var movieDtos = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/movies?title=incredibles")
                .then()
                .statusCode(200)
                .extract()
                .body().as(MovieDto[].class);

        assertThat(movieDtos)
                .hasSize(1)
                .contains(MovieDtoFixture.theIncredibles());
    }
}

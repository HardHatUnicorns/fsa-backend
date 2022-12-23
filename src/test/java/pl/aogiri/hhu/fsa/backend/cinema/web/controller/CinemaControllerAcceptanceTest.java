package pl.aogiri.hhu.fsa.backend.cinema.web.controller;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDetailsDto;
import pl.aogiri.hhu.fsa.backend.common.AcceptanceTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Sql({
        "classpath:/sql/user/users.sql",
        "classpath:/sql/cinema/cinema_city.sql",
})
@Sql(value = "classpath:/sql/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CinemaControllerAcceptanceTest extends AcceptanceTest {
    @Test
    void shouldReturnCinemaDetails() {
        final var detailsDto = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/cinemas/1")
                .then()
                .statusCode(200)
                .extract()
                .body().as(CinemaDetailsDto.class);

        assertThat(detailsDto).isEqualTo(CinemaDetailsDtoFixture.cinemaCity());
    }
}

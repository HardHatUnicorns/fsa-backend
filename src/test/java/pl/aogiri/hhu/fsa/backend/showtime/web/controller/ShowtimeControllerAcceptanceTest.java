package pl.aogiri.hhu.fsa.backend.showtime.web.controller;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import pl.aogiri.hhu.fsa.backend.common.AcceptanceTest;
import pl.aogiri.hhu.fsa.backend.showtime.application.dto.ShowtimeDto;
import pl.aogiri.hhu.fsa.backend.showtime.application.mapper.ShowtimeDtoFixture;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Sql({
        "classpath:/sql/genre/genres.sql",
        "classpath:/sql/user/users.sql",
        "classpath:/sql/movie/the_incredibles.sql",
        "classpath:/sql/cinema/cinema.sql",
        "classpath:/sql/cinema/cinema_facility.sql",
        "classpath:/sql/showtime/showtime_bonarka.sql",
})
@Sql(value = "classpath:/sql/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ShowtimeControllerAcceptanceTest extends AcceptanceTest {
    @Test
    void shouldReturnAllShowtimeInDatabase() {
        final var showtimeDtos = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/showtimes")
                .then()
                .statusCode(200)
                .extract()
                .body().as(ShowtimeDto[].class);

        assertThat(showtimeDtos)
                .hasSize(1)
                .contains(ShowtimeDtoFixture.showtimeTheIncrediblesInCinemaCityBonarka());
    }
}

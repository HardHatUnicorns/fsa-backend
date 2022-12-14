package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import pl.aogiri.hhu.fsa.backend.movie.domain.entity.ScoreEntity;

import java.math.BigDecimal;

public class ScoreEntityFixture {

    public static ScoreEntity johnDon_theIncredibles_score(String score) {
        final var scoreEntity = new ScoreEntity();
        scoreEntity.setUser(UserEntityFixture.johnDoe());
        scoreEntity.setScore(new BigDecimal(score));
        return scoreEntity;
    }

    public static ScoreEntity janeDoe_theIncredibles_score(String score) {
        final var scoreEntity = new ScoreEntity();
        scoreEntity.setUser(UserEntityFixture.janeDoe());
        scoreEntity.setScore(new BigDecimal(score));
        return scoreEntity;
    }

    public static ScoreEntity johnSmith_theIncredibles_score(String score) {
        final var scoreEntity = new ScoreEntity();
        scoreEntity.setUser(UserEntityFixture.johnSmith());
        scoreEntity.setScore(new BigDecimal(score));
        return scoreEntity;
    }
}

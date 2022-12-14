package pl.aogiri.hhu.fsa.backend.movie.domain.entity;

import lombok.Data;
import pl.aogiri.hhu.fsa.backend.auth.user.entity.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "score")
public class ScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @Column(precision = 2)
    @Max(10)
    @Min(1)
    private BigDecimal score;
}

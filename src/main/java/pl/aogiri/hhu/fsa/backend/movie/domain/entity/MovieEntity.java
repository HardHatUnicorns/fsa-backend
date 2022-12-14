package pl.aogiri.hhu.fsa.backend.movie.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Length(max = 64)
    private String title;

    @NotEmpty
    @Length(max = 1024)
    private String description;

    @OneToMany(mappedBy = "movie")
    private List<ScoreEntity> scores;

    @ManyToMany
    private List<GenreEntity> genres;

    @NotNull
    private int durationInMinutes;

    @NotNull
    private LocalDate releaseDate;

    @NotEmpty
    private String productionCountry;

    @NotEmpty
    private String director;

    @UpdateTimestamp
    private Timestamp updated;

    @CreationTimestamp
    private Timestamp created;
}

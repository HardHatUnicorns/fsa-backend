package pl.aogiri.hhu.fsa.backend.cinema.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "cinema")
public class CinemaEntity {

    @Id
    private Long id;

    @NotEmpty
    @Length(max = 64)
    private String name;

    @Length(max = 64)
    private String url;

    @UpdateTimestamp
    private Timestamp updated;

    @CreationTimestamp
    private Timestamp created;
}

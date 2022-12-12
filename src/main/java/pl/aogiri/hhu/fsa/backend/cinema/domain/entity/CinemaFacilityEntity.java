package pl.aogiri.hhu.fsa.backend.cinema.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "cinema_facility")
public class CinemaFacilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Length(max = 1024)
    private String description;

    @NotEmpty
    @Length(max = 128)
    private String address;

    @NotEmpty
    @Length(max = 32)
    private String telephone;

    @NotEmpty
    @Length(max = 64)
    @Email
    private String email;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaEntity cinema;

    @UpdateTimestamp
    private Timestamp updated;

    @CreationTimestamp
    private Timestamp created;
}

package pl.aogiri.hhu.fsa.backend.facility.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "facility")
public class FacilityEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

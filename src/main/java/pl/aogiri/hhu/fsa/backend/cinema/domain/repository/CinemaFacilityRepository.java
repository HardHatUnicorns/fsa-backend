package pl.aogiri.hhu.fsa.backend.cinema.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

public interface CinemaFacilityRepository extends JpaRepository<CinemaFacilityEntity, Long> {
}

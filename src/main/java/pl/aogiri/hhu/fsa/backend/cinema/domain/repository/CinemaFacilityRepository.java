package pl.aogiri.hhu.fsa.backend.cinema.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

import java.util.List;

public interface CinemaFacilityRepository extends JpaRepository<CinemaFacilityEntity, Long> {
    List<CinemaFacilityEntity> findAllByCinemaId(Long CinemaId);
}

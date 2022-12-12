package pl.aogiri.hhu.fsa.backend.cinema.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;

public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {
}

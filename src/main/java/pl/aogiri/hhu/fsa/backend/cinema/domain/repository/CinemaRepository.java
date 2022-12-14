package pl.aogiri.hhu.fsa.backend.cinema.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;

@Repository
public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {
}

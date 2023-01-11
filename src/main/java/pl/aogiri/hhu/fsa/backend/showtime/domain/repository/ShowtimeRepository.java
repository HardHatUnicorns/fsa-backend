package pl.aogiri.hhu.fsa.backend.showtime.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aogiri.hhu.fsa.backend.showtime.domain.entity.ShowtimeEntity;

public interface ShowtimeRepository extends JpaRepository<ShowtimeEntity, Long> {
}

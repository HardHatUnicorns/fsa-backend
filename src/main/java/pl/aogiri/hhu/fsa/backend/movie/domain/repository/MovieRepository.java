package pl.aogiri.hhu.fsa.backend.movie.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}

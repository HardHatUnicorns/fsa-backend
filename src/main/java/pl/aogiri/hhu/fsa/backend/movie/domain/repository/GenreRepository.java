package pl.aogiri.hhu.fsa.backend.movie.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.GenreEntity;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    List<GenreEntity> findAllByIdIn(List<Long> genresIds);
}

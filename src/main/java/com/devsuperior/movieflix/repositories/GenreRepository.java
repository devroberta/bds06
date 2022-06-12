package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.projections.GenreMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

  @Query(nativeQuery = true, value = "SELECT id, name FROM tb_genre")
  List<GenreMinProjection> findAllGenre();
}

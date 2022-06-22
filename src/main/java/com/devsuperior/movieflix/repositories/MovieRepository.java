package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

 @Query("SELECT DISTINCT  obj "
          + "FROM Movie obj INNER JOIN obj.genre genres "
          + "WHERE COALESCE (:genres) IS NULL OR genres IN :genres "
          + "ORDER BY obj.title")
  Page<Movie> findMovieByGenre(List<Genre> genres, Pageable pageable);
}
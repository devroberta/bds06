package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.projections.ReviewMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

  @Query(nativeQuery = true, value = "SELECT tb_review.id, tb_review.text, tb_review.movie_id "
          +"FROM tb_review "
          +"WHERE tb_review.movie_id = :movieId")
  List<ReviewMinProjection> findReviewByMovieId(Long movieId);
}
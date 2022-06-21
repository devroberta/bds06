package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.dto.ReviewMinDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

  @Autowired
  private MovieService serviceMovie;

  @Autowired
  private ReviewService serviceReview;

  @GetMapping(value = "/{id}")
  public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
    MovieDTO dto = serviceMovie.findById(id);
    return ResponseEntity.ok().body(dto);
  }

  @GetMapping("/{movieId}/reviews")
  public ResponseEntity<List<ReviewMinDTO>> findMovieByReview(@PathVariable Long movieId) {
    List<ReviewMinDTO> list = serviceReview.findReviewByMovie(movieId);
    return ResponseEntity.ok(list);
  }

  @GetMapping
  public ResponseEntity<Page<MovieMinDTO>> findMovieByGenre (
          @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
          Pageable pageable) {

    Page<MovieMinDTO> page = serviceMovie.findMovieByGenre(genreId, pageable);
    return ResponseEntity.ok().body(page);
  }
}
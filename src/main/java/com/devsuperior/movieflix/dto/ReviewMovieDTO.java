package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projections.ReviewMinProjection;

import java.util.Objects;

public class ReviewMovieDTO {

  private Long id;
  private String text;
  private Long movieId;

  public ReviewMovieDTO() {
  }

  public ReviewMovieDTO(Long id, String text, Long movieId) {
    this.id = id;
    this.text = text;
    this.movieId = movieId;
  }

  public ReviewMovieDTO(ReviewMinProjection projection) {
    id = projection.getId();
    text = projection.getText();
    movieId = projection.getMovieId();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getMovieId() {
    return movieId;
  }

  public void setMovieId(Long movieId) {
    this.movieId = movieId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReviewMovieDTO that = (ReviewMovieDTO) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
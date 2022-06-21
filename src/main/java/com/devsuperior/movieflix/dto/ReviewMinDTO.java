package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projections.ReviewMinProjection;

import java.util.Objects;

public class ReviewMinDTO {

  private Long id;
  private String text;
  private Long movieId;
  private Long userId;

  public ReviewMinDTO() {
  }

  public ReviewMinDTO(Long id, String text, Long movieId, Long userId) {
    this.id = id;
    this.text = text;
    this.movieId = movieId;
    this.userId = userId;
  }

  public ReviewMinDTO(ReviewMinProjection projection) {
    id = projection.getId();
    text = projection.getText();
    userId = projection.getUserId();
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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReviewMinDTO that = (ReviewMinDTO) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
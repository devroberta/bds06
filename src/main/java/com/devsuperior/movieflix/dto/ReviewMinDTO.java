package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projections.ReviewMinProjection;

import java.util.Objects;

public class ReviewMinDTO {

  private Long id;
  private String text;
  private Long movieId;
  private UserDTO user;

  public ReviewMinDTO() {
  }

  public ReviewMinDTO(Long id, String text, Long movieId, UserDTO userDTO) {
    this.id = id;
    this.text = text;
    this.movieId = movieId;
    this.user = userDTO;
  }

  public ReviewMinDTO(ReviewMinProjection projection, Movie movie, User user) {
    id = projection.getId();
    text = projection.getText();
    this.user = new UserDTO(user);
    movieId = movie.getId();
  }

  public ReviewMinDTO(Review review) {
    id = review.getId();
    text = review.getText();
    user = new UserDTO(review.getUser());
    movieId = review.getMovie().getId();
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

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
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
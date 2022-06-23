package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projections.ReviewMinProjection;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class ReviewDTO {

  private Long id;

  @NotBlank(message = "Campo de preenchimento obrigatório")
  private String text;
  private Long movieId;
  private UserDTO user;

  public ReviewDTO() {
  }

  public ReviewDTO(Long id, String text, Long movieId, UserDTO userDTO) {
    this.id = id;
    this.text = text;
    this.movieId = movieId;
    this.user = userDTO;
  }

  public ReviewDTO(ReviewMinProjection projection, Movie movie, User user) {
    id = projection.getId();
    text = projection.getText();
    this.user = new UserDTO(user);
    movieId = movie.getId();
  }

  public ReviewDTO(Review review) {
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
    ReviewDTO that = (ReviewDTO) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
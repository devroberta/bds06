package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

import java.util.Objects;

public class ReviewDTO {

  private Long id;
  private String text;
  private User user;
  private Long movieId;

  public ReviewDTO() {
  }

  public ReviewDTO(Long id, String text, User user, Long movieId) {
    this.id = id;
    this.text = text;
    this.user = user;
    this.movieId = movieId;
  }

  public ReviewDTO(Review review) {
    id = review.getId();
    text = review.getText();
    user = review.getUser();
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getMovieId(){
    return movieId;
  }
  public void setMovieId(Long movieId) {
    this.movieId = movieId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReviewDTO reviewDTO = (ReviewDTO) o;
    return Objects.equals(id, reviewDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

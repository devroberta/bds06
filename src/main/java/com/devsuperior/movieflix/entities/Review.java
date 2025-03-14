package com.devsuperior.movieflix.entities;

import com.devsuperior.movieflix.dto.ReviewDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_review")
public class Review implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String text;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;

  public Review() {
  }

  public Review(Long id, String text, Movie movie, User user) {
    this.id = id;
    this.text = text;
    this.movie = movie;
    this.user = user;
  }

  public Review(ReviewDTO reviewDTO) {
    id = reviewDTO.getId();
    text = reviewDTO.getText();
    movie.setId(reviewDTO.getMovieId());
    user.setId(reviewDTO.getUser().getId());
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

  public Movie getMovie() {
    return movie;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Review review = (Review) o;
    return Objects.equals(id, review.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

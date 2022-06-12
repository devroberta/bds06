package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDTO {

  private Long id;
  private String title;
  private String subTitle;
  private Integer year;
  private String imgUrl;
  private String synopsis;
  private List<ReviewDTO> reviews = new ArrayList<>();
  private Genre genre;

  public MovieDTO() {
  }

  public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
    this.id = id;
    this.title = title;
    this.subTitle = subTitle;
    this.year = year;
    this.imgUrl = imgUrl;
    this.synopsis = synopsis;
  }

  public MovieDTO(Movie movie) {
    id = movie.getId();
    title = movie.getTitle();
    subTitle = movie.getSubTitle();
    year = movie.getYear();
    imgUrl = movie.getImgUrl();
    synopsis = movie.getSynopsis();
  }

  public MovieDTO(Movie movie, List<Review> reviews) {
    this(movie);
    reviews.forEach(x -> this.reviews.add(new ReviewDTO(x)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public List<ReviewDTO> getReviews() {
    return reviews;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MovieDTO movieDTO = (MovieDTO) o;
    return Objects.equals(id, movieDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

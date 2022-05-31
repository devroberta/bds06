package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenreDTO {

  private Long id;
  private String name;
  private List<Movie> movies = new ArrayList<>();

  public GenreDTO() {
  }

  public GenreDTO(Long id, String name, List<Movie> movies) {
    this.id = id;
    this.name = name;
    this.movies = movies;
  }

  public GenreDTO(Genre genre) {
    id = genre.getId();
    name = genre.getName();
    movies = genre.getMovies();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GenreDTO genreDTO = (GenreDTO) o;
    return Objects.equals(id, genreDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

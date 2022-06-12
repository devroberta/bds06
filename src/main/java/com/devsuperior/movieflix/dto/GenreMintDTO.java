package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.projections.GenreMinProjection;

public class GenreMintDTO {

  private Long id;
  private String name;

  public GenreMintDTO() {
  }

  public GenreMintDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public GenreMintDTO(GenreMinProjection projection) {
    id = projection.getId();
    name = projection.getName();  }

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
}

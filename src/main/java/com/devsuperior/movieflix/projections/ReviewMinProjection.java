package com.devsuperior.movieflix.projections;

import com.devsuperior.movieflix.entities.User;

public interface ReviewMinProjection {

  Long getId();

  String getText();

 // User getUser();

  Long getMovieId();
}

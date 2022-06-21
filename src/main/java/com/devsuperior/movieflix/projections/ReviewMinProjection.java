package com.devsuperior.movieflix.projections;

import com.devsuperior.movieflix.entities.User;

public interface ReviewMinProjection {

  Long getId();

  String getText();

  Long getUserId();

  Long getMovieId();
}

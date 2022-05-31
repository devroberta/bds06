package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

  @Autowired
  private MovieRepository repository;

  @Transactional(readOnly=true)
  public MovieDTO findById(Long id) {
    Optional<Movie> obj = repository.findById(id);
    Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found."));
    return new MovieDTO(movie);
  }
}

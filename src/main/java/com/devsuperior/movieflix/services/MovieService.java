package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

  @Autowired
  private MovieRepository repository;

  @Autowired
  private GenreRepository genreRepository;

  @Transactional(readOnly=true)
  public MovieDTO findById(Long id) {
    Optional<Movie> obj = repository.findById(id);
    Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found."));
    return new MovieDTO(movie);
  }

  /*@Transactional(readOnly=true)
  public Page<MovieMinDTO> findMovieByGenre(Long genreId, PageRequest pageRequest) {
    Page<MovieMinDTO> movieList = (genreId == 0) ? null : repository.findMovieByGenre(genreId);
    return movieList;
  }*/
}

package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

  @Autowired
  private MovieRepository repository;

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private GenreRepository genreRepository;

  @Autowired
  private AuthService authService;

  @Transactional(readOnly=true)
  public MovieDTO findById(Long id) {
    Optional<Movie> obj = repository.findById(id);
    Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found."));
    return new MovieDTO(movie);
  }

  @Transactional(readOnly=true)
  public Page<MovieMinDTO> findMovieByGenre(Long genreId, Pageable pageable) {
    List<Genre> genres = (genreId == 0) ? null :
            Arrays.asList(genreRepository.getOne(genreId));
    Page<Movie> list = repository.findMovieByGenre(genres, pageable);
    return list.map(x -> new MovieMinDTO(x));
  }
}


package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projections.ReviewMinProjection;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

  @Autowired
  private ReviewRepository repository;
  @Autowired
  private MovieRepository movieRepository;
  @Autowired
  private AuthService authService;

  @Transactional(readOnly=true)
  public List<ReviewDTO> findReviewByMovie(Long movieId) {
    User user = authService.authenticated();
    Optional<Movie> movie = movieRepository.findById(movieId);
    List<ReviewMinProjection> list = repository.findReviewByMovieId(movieId);
    List<ReviewDTO> result =
            list.stream().map(x -> new ReviewDTO(x, movie.get(), user)).collect(Collectors.toList());
    return result;
  }

  @Transactional
  public ReviewDTO insert(ReviewDTO dto) {
    User user = authService.authenticated();
    Optional<Movie> movie = movieRepository.findById(dto.getMovieId());
    Review review = new Review();
    review.setText(dto.getText());
    review.setMovie(movie.get());
    review.setUser(user);
    review = repository.save(review);
    return new ReviewDTO(review);
  }
}

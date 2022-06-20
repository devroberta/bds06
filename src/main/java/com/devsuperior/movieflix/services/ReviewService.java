package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewMovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projections.ReviewMinProjection;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
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
  public List<ReviewMovieDTO> findReviewByMovie(Long movieId) {
    List<ReviewMinProjection> list = repository.findReviewByMovieId(movieId);
    List<ReviewMovieDTO> result = list.stream().map(x -> new ReviewMovieDTO(x)).collect(Collectors.toList());
    return result;
  }

  @Transactional
  public ReviewDTO insert(ReviewDTO dto) {

    User user = authService.authenticated();

    Review review = new Review();
    review.setMovie(movieRepository.getOne(dto.getMovie().getId()));
    review.setUser(user);
    review.setText(dto.getText());
    review = repository.save(review);
    return new ReviewDTO(review);
  }
}

package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewMinDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projections.ReviewMinProjection;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  public List<ReviewMinDTO> findReviewByMovie(Long movieId) {
    List<ReviewMinProjection> list = repository.findReviewByMovieId(movieId);
    List<ReviewMinDTO> result = list.stream().map(x -> new ReviewMinDTO(x)).collect(Collectors.toList());
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

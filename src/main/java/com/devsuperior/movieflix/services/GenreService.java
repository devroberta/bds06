package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.GenreMintDTO;
import com.devsuperior.movieflix.projections.GenreMinProjection;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

  @Autowired
  private GenreRepository repository;

  @Transactional(readOnly=true)
  public List<GenreMintDTO> findAll() {
    List<GenreMinProjection> list = repository.findAllGenre();
    return list.stream().map(x -> new GenreMintDTO(x)).collect(Collectors.toList());
  }
}
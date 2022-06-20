package com.devsuperior.movieflix.controllers.exceptions;

import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError("Requisição não encontrada");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request) {
    OAuthCustomError err = new OAuthCustomError("Forbidden", e.getMessage());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request) {
    OAuthCustomError err = new OAuthCustomError("Unauthorized", e.getMessage());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
  }
}

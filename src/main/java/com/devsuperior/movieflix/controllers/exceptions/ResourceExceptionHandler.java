package com.devsuperior.movieflix.controllers.exceptions;

import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

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

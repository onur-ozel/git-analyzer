package com.onur.scout24.exception;

import java.util.UUID;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> exception(Exception ex, WebRequest request) {
    ApiError apiError = new ApiError(HttpStatus.ALREADY_REPORTED);
    apiError.setMessage(ex.getMessage());

    apiError.setLogId(UUID.randomUUID().toString());
    // TODO write this logs to some persistence source. stacktrace etc, user info
    // etc, map exception log with id .

    return buildResponseEntity(apiError);
  }

  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }
}
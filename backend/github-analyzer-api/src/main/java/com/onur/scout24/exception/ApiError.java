package com.onur.scout24.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
class ApiError {

  private HttpStatus status;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;
  private String message;
  private String logId;

  private ApiError() {
    timestamp = LocalDateTime.now();
  }

  ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  ApiError(HttpStatus status, String message) {
    this();
    this.status = status;
    this.message = message;
  }
}
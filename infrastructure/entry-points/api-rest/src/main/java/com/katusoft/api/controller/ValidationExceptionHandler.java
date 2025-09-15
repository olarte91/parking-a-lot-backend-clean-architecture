package com.katusoft.api.controller;


import com.katusoft.api.dto.ErrorResponse;
import com.katusoft.model.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Maneja las excepciones a nivel de infraestructura.
 * Toma las excepciones a nivel de dominio y las convirte en respuesta para el usuario
 * */
@ControllerAdvice
public class ValidationExceptionHandler {

  // 1. VALIDACIONES DTO (Bean Validation)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {

    Map<String, String> fieldErrors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      fieldErrors.put(fieldName, errorMessage);
    });

    ErrorResponse response = ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .error("Validation Failed")
        .message("Input validation errors")
        .fieldErrors(fieldErrors)
        .build();

    return ResponseEntity.badRequest().body(response);
  }

  // EXCEPCIONES DE DOMINIO - User Already Exists
  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {

    ErrorResponse response = ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.CONFLICT.value())
        .error("User Already Exists")
        .message(ex.getMessage())
        .build();

    return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
  }
}

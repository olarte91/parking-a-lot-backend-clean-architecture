package com.katusoft.api.handler;

import com.katusoft.model.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
      String details = ex.getBindingResult().getFieldErrors().stream()
          .map(error -> error.getField() + ":" + error.getDefaultMessage())
          .collect(Collectors.joining(", "));
      return ResponseEntity.badRequest().body(new ErrorResponse("400", "Datos inválidos", details));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorResponse> handleReadable(HttpMessageNotReadableException ex) {
    return ResponseEntity.badRequest()
        .body(new ErrorResponse("400", "JSON Parse Error", "El formato del JSON es inválido o hay tipos de datos incompatibles"));
  }

  //Excepciones de dominio

  @ExceptionHandler(DomainException.class)
  public ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
        .body(new ErrorResponse(
            ex.getCode(),
            ex.getMessage(),
            "Violación de reglas de dominio"));
  }

}

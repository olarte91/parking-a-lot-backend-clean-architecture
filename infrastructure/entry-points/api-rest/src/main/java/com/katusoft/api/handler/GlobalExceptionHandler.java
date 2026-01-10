package com.katusoft.api.handler;

import com.katusoft.model.exception.DomainException;
import com.katusoft.model.exception.InvalidParkingSpaceNumberException;
import com.katusoft.model.exception.ParkingSpaceAlreadyExistsException;
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
        .body(new ErrorResponse("422", "Violación de reglas de dominio", ex.getMessage()));
  }

  @ExceptionHandler(ParkingSpaceAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleParkingSpaceExists(ParkingSpaceAlreadyExistsException ex) {
    ErrorResponse error = new ErrorResponse("409", "Domain Exception - Conflict", ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
  }

////  @ExceptionHandler(InvalidParkingSpaceNumberException.class)
////  public ResponseEntity<ErrorResponse> handleInvalidParkingSpaceNumber(InvalidParkingSpaceNumberException ex) {
////    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
////        new ErrorResponse("400", "Domain Exception - parkingspace number out of range", ex.getMessage())
////    );
//  }
}

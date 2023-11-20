package br.com.victor.resources;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.victor.services.exception.ExceptionResponse;
import br.com.victor.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, HttpServletRequest request) {
        ExceptionResponse err = new ExceptionResponse(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ExceptionResponse> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        ExceptionResponse err = new ExceptionResponse(Instant.now(), HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    
}

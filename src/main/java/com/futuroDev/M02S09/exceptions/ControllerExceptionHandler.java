package com.futuroDev.M02S09.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    protected ResponseEntity<ProblemDetail> handleUserAlreadyRegisteredException(ProductNotFoundException e,
                                                                                 HttpServletRequest request) {
        String detail = e.getMessage();
        HttpStatus conflict = HttpStatus.NOT_FOUND;
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(conflict, detail);
        problemDetail.setTitle(e.getMessage());
        return ResponseEntity.status(conflict).body(problemDetail);
    }
}
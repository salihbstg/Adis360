package com.adis360.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    private GlobalExceptionResponse buildErrorResponse(String message, int status) {
        return new GlobalExceptionResponse(
                message,
                LocalDateTime.now(),
                status
        );
    }

    @ExceptionHandler(OwnerRoleNotAllowedException.class)
    public ResponseEntity<GlobalExceptionResponse> ownerRoleNotAllowedExceptionHandler(
            OwnerRoleNotAllowedException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST.value())
                .body(
                        buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value())
                );
    }

}

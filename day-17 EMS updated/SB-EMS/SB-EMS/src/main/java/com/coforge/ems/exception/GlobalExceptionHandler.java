package com.coforge.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Global exception handler to intercept exceptions thrown by controllers
 * and return structured JSON error responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles InvalidEmployeeObjectException.
     * Returns 404 Not Found for lookup/id failures, and 400 Bad Request for invalid objects.
     *
     * @param ex the exception instance
     * @return response entity containing error details
     */
    @ExceptionHandler(InvalidEmployeeObjectException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidEmployeeObjectException(InvalidEmployeeObjectException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());

        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = ex.getMessage();
        
        // Differentiate based on the error context
        if (message != null && (
                message.toLowerCase().contains("null") || 
                message.toLowerCase().contains("invalid employee") || 
                message.toLowerCase().contains("cannot be null")
           )) {
            status = HttpStatus.BAD_REQUEST;
        }

        response.put("status", status.value());
        response.put("error", status.getReasonPhrase());
        response.put("message", message);

        return new ResponseEntity<>(response, status);
    }

    /**
     * Handles validation exceptions (e.g. invalid request body field values).
     * Returns HTTP 400 Bad Request.
     *
     * @param ex the validation exception
     * @return response entity containing field-wise validation errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());

        // Extract field-level errors
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> fieldError.getDefaultMessage() != null ? fieldError.getDefaultMessage() : "Invalid value",
                        (existing, replacement) -> existing
                ));

        String summaryMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));

        response.put("message", "Validation failed: " + summaryMessage);
        response.put("details", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Fallback exception handler for any other unhandled server exceptions.
     * Returns HTTP 500 Internal Server Error.
     *
     * @param ex the general exception
     * @return response entity containing internal server error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.put("message", "An unexpected error occurred: " + ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

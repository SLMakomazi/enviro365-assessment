/*
 * GlobalExceptionHandler.java
 * Centralized exception handling for the entire application.
 * Uses Spring @ControllerAdvice to intercept and handle exceptions globally.
 * Maps custom exceptions to appropriate HTTP responses with error details.
 */
package com.enviro.assessment.junior.siseko_makomazi.exception; // Exception layer package

import org.springframework.http.HttpStatus; // HTTP status codes
import org.springframework.http.ResponseEntity; // HTTP response wrapper
import org.springframework.web.bind.annotation.ControllerAdvice; // Global exception handling annotation
import org.springframework.web.bind.annotation.ExceptionHandler; // Exception handler method annotation

import java.util.HashMap; // For creating response maps
import java.util.Map; // For key-value pairs

@ControllerAdvice // Marks this class to handle exceptions globally across all controllers
public class GlobalExceptionHandler {

    /**
     * Handles InsufficientBalanceException and returns HTTP 400 BAD_REQUEST
     * @param ex The caught InsufficientBalanceException
     * @return ResponseEntity with error message and 400 status
     */
    @ExceptionHandler(InsufficientBalanceException.class) // Intercept InsufficientBalanceException
    public ResponseEntity<Map<String, String>> handleInsufficientBalance(InsufficientBalanceException ex) {
        Map<String, String> response = new HashMap<>(); // Create response map
        response.put("error", ex.getMessage()); // Add exception message to response
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // Return 400 Bad Request
    }

    /**
     * Handles AgeRestrictionException and returns HTTP 403 FORBIDDEN
     * @param ex The caught AgeRestrictionException
     * @return ResponseEntity with error message and 403 status
     */
    @ExceptionHandler(AgeRestrictionException.class) // Intercept AgeRestrictionException
    public ResponseEntity<Map<String, String>> handleAgeRestriction(AgeRestrictionException ex) {
        Map<String, String> response = new HashMap<>(); // Create response map
        response.put("error", ex.getMessage()); // Add exception message to response
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response); // Return 403 Forbidden
    }

    /**
     * Handles all other unexpected exceptions and returns HTTP 500 INTERNAL_SERVER_ERROR
     * @param ex Any Exception not specifically handled above
     * @return ResponseEntity with generic error message and 500 status
     */
    @ExceptionHandler(Exception.class) // Intercept all other exceptions (catch-all)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> response = new HashMap<>(); // Create response map
        response.put("error", "An unexpected error occurred."); // Add generic error message
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // Return 500 Internal Server Error
    }
}


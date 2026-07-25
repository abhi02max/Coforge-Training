package com.example.pms.exception;

/**
 * Custom exception thrown when a requested Product is not found.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}

package com.futuroDev.M02S09.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Product not found: " + id);
    }
}

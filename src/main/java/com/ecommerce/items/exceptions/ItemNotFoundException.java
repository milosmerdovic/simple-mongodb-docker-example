package com.ecommerce.items.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(){
        super();
    }
    public ItemNotFoundException(String message) {
        super(message);
    }
}

package com.example.javaposts.exception;

public class NotCorrectUser extends RuntimeException {
    public NotCorrectUser(String message) {
        super(message);
    }
}

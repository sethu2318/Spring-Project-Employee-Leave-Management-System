package com.example.leave.exception;

public class LeaveNotFoundException extends RuntimeException {

    public LeaveNotFoundException(String message) {
        super(message);
    }
}

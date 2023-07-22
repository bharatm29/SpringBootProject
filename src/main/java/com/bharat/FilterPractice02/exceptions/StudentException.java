package com.bharat.FilterPractice02.exceptions;

public class StudentException extends Exception {
    private String message;
    private static final long serialVersionUID = 1L;

    public StudentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

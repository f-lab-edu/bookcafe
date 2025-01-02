package com.study.bookcafe.application.exception;

public class BorrowableException extends RuntimeException {
    public BorrowableException(String message) {
        super(message);
    }

    public BorrowableException(String message, Throwable cause) {
        super(message, cause);
    }
}

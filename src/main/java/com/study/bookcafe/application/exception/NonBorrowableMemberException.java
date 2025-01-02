package com.study.bookcafe.application.exception;

public class NonBorrowableMemberException extends RuntimeException {
    public NonBorrowableMemberException(String message) {
        super(message);
    }

    public NonBorrowableMemberException(String message, Throwable cause) {
        super(message, cause);
    }
}

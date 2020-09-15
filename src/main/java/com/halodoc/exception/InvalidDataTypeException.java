package com.halodoc.exception;

public class InvalidDataTypeException extends RuntimeException {
    public InvalidDataTypeException(String message) {
        super(message);
    }

    public InvalidDataTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}

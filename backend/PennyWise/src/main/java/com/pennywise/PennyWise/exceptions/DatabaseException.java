package com.pennywise.PennyWise.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message, Throwable cause){
        super(message, cause);
    }
}

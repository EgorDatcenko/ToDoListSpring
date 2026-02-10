package com.example.to_do_list.exception;

public class NoFoundTaskException extends RuntimeException {
    public NoFoundTaskException(String message) {
        super(message);
    }
}

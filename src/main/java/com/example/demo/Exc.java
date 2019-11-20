package com.example.demo;

public class Exc extends Exception {
    public Exc() {
    }

    public Exc(String message) {
        super(message);
    }

    public Exc(String message, Throwable cause) {
        super(message, cause);
    }

    public Exc(Throwable cause) {
        super(cause);
    }

    public Exc(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

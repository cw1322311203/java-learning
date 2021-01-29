package com.cw.httpserver;

public class NotImplementsHttpServletException extends RuntimeException{

    public NotImplementsHttpServletException() {
    }

    public NotImplementsHttpServletException(String message) {
        super(message);
    }
}

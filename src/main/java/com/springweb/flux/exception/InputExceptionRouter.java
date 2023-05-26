package com.springweb.flux.exception;

public class InputExceptionRouter extends RuntimeException{
    private final  int input;
    static final int errorCode=100;
    public InputExceptionRouter(int input) {
        super("input must not greater than 100");
        this.input = input;
    }
    public int getInput() {
        return input;
    }
    public int getErrorCode() {
        return errorCode;
    }
}

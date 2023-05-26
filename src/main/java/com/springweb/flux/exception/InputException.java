package com.springweb.flux.exception;

public class InputException extends RuntimeException{
    private final  int input;
    static final int errorCode=100;
    public InputException(int input) {
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

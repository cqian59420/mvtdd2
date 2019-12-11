package com.ngari.mvtdd2.exception;

public class BusException extends RuntimeException {
    public BusException(String msg) {
        this.msg = msg;
    }

    private String msg;
}

package com.ngari.mvtdd2.exception;

public class CarNotFoundException extends RuntimeException {
    private String msg;

    public CarNotFoundException(String ms) {
        this.msg = ms;
    }
}

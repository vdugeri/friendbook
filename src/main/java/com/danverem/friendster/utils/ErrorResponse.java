package com.danverem.friendster.utils;

public class ErrorResponse {

    private String message;
    private String status;

    public ErrorResponse(String message) {
        this(message, "error");
    }

    public ErrorResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }


}

package com.example.demo.bo;

public class ServiceResponse {

    public String code;
    public String message;

    public ServiceResponse() {};

    public ServiceResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

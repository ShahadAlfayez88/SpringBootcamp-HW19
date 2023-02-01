package com.example.springday09.Exception;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
}

package com.galvanize.gmdbapi.exception;

public class NotExistMovieException extends RuntimeException{
    public NotExistMovieException(String message){
        super(message);
    }
}

package com.task.exceptions;

public class EmptyFileNameException extends RuntimeException{
    public EmptyFileNameException (String msg){
        super(msg);
    }
}

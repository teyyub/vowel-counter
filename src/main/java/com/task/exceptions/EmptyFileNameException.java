package com.task.exceptions;

public class EmptyFileNameException extends RuntimeException{
    public EmptyFileNameException (){
        super("File name cannot be empty");
    }
}

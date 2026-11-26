package com.adis360.exception;

public class OwnerRoleNotAllowedException extends RuntimeException {
    public OwnerRoleNotAllowedException(String message){
        super(message);
    }
}

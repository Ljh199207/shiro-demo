package com.example.springsecurity.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author ljh
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 5022575393500654458L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}

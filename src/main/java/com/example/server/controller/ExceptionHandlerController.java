package com.example.server.controller;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.server.exceptions.UserIsBlockedException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserIsBlockedException.class)
    public ResponseEntity<Object> handleBlockedUser() {
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<Object> handleBadCredentials(TokenExpiredException ex) {
        return new ResponseEntity<>(generateErrorResponse("expiredToken", ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleAlreadyExistEmail() {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    private Map<String, Object> generateErrorResponse(String reason, String msg) {
        Map<String, Object> body = new HashMap<>();
        body.put("reason", reason);
        body.put("message", msg);

        return body;
    }
}

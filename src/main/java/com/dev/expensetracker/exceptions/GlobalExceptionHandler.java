package com.dev.expensetracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.dev.expensetracker.entity.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ErrorObject> constructException(Exception ex, WebRequest req, HttpStatus statusCode) {
        ErrorObject errorObject = new ErrorObject();

        errorObject.setStatusCode(statusCode.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<ErrorObject>(errorObject, statusCode);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        return constructException(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {

        return constructException(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request) {
        
        return constructException(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

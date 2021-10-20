package com.training.spring.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlers {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final IllegalArgumentException exceptionParam) {

        return new ErrorObj().setDomain("Person")
                             .setSubdomain("care")
                             .setBoundedContext("provision")
                             .setMicroservice("management")
                             .setErrorCause(1000)
                             .setDesc(exceptionParam.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final MethodArgumentNotValidException exceptionParam) {
        ErrorObj rootError = new ErrorObj().setDomain("Person")
                                           .setSubdomain("care")
                                           .setBoundedContext("provision")
                                           .setMicroservice("management")
                                           .setErrorCause(2000)
                                           .setDesc("Validation error");
        List<ObjectError> allErrorsLoc = exceptionParam.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(new ErrorObj().setDomain("Person")
                                                .setSubdomain("care")
                                                .setBoundedContext("provision")
                                                .setMicroservice("management")
                                                .setErrorCause(2001)
                                                .setDesc(objectErrorLoc.toString()));
        }

        return rootError;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleError(final Exception exceptionParam) {
        return new ErrorObj().setDomain("Person")
                             .setSubdomain("care")
                             .setBoundedContext("provision")
                             .setMicroservice("management")
                             .setErrorCause(7000)
                             .setDesc(exceptionParam.getMessage());
    }

}

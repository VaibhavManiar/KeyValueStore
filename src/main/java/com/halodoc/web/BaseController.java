package com.halodoc.web;

import com.halodoc.api.Failure;
import com.halodoc.exception.InvalidDataTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @ExceptionHandler(InvalidDataTypeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Failure handleInvalidDataTypeException(InvalidDataTypeException e) {
        return new Failure(new Failure.Error(e.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Failure handleInvalidDataTypeException(NullPointerException e) {
        return new Failure(new Failure.Error(e.getMessage()));
    }
}

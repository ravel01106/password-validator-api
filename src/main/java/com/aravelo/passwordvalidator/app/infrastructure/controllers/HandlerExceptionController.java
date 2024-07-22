package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.aravelo.passwordvalidator.app.domain.models.ErrorDTO;
import com.aravelo.passwordvalidator.app.domain.ports.ErrorTypes;

@ControllerAdvice
public class HandlerExceptionController {

  @ExceptionHandler(HttpMessageNotReadableException.class)
  ResponseEntity<ErrorDTO> emptyBodyException(HttpMessageNotReadableException exception){
    ErrorDTO errorDTO = new ErrorDTO("The body is empty !!!", HttpStatus.BAD_REQUEST.value(),
    exception.getMessage(), ErrorTypes.EMPTY_BODY);
    return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(NoResourceFoundException.class)
  ResponseEntity<ErrorDTO> incorrectPathException(NoResourceFoundException exception){
    ErrorDTO errorDTO = new ErrorDTO("This path does not exist !!!", HttpStatus.NOT_FOUND.value(),
    exception.getMessage(), ErrorTypes.FAIL_PATH);
    return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
  }


}

package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aravelo.passwordvalidator.app.domain.models.ErrorDTO;
import com.aravelo.passwordvalidator.app.domain.ports.ErrorTypes;

@ControllerAdvice
public class HandlerExceptionController {

  @ExceptionHandler(HttpMessageNotReadableException.class)
  ResponseEntity<ErrorDTO> incompleteBodyException(HttpMessageNotReadableException exception){
    ErrorDTO errorDTO = new ErrorDTO("The body is incomplete !!!", 400, exception.getMessage(), ErrorTypes.INCOMPLETE_BODY);
    return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
  }


}

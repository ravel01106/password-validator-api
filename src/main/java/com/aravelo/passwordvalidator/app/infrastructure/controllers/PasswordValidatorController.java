package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;
import com.aravelo.passwordvalidator.app.domain.ports.PasswordValidatedUseCase;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/app")
public class PasswordValidatorController {

  @Autowired
  PasswordValidatedUseCase passwordValidatedUseCase;

  @PostMapping("/validate/{password}")
  ResponseEntity<ResultPasswordValidator> validatePassword(
    @PathVariable("password") String password,
    @RequestBody Validator validator){
    try {
      ResultPasswordValidator resultPasswordValidator = passwordValidatedUseCase.validatePassword(password, validator);
      return new ResponseEntity<ResultPasswordValidator>(resultPasswordValidator, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}

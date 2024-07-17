package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/app")
public class PasswordValidatorController {

  @PostMapping("/validate/{password}")
  ResponseEntity<String> validatePassword(
    @PathVariable("password") String password,
    @RequestBody Validator validator){

    return new ResponseEntity<String>("Hola mundo", HttpStatus.INTERNAL_SERVER_ERROR);
  }


}

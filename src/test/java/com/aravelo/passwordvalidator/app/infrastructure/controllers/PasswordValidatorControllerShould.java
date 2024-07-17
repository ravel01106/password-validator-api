package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import static org.mockito.Mockito.when;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;
import com.aravelo.passwordvalidator.app.domain.ports.PasswordValidatedUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PasswordValidatorController.class)
public class PasswordValidatorControllerShould {

  // Permit a password when meet all the conditions
  // Don't permit a password if it does not meet the conditions

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PasswordValidatedUseCase passwordValidatedUseCase;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void permitPasswordWhenMeetAllTheConditions() throws Exception{
    String password = "Pepe56789_";
    String url = "/app/validate/" + password;
    Validator validator = new Validator(6, true, true, true, true);
    ResultPasswordValidator resultPasswordValidator = new ResultPasswordValidator(true);
    when(passwordValidatedUseCase.validatePassword(password, validator))
      .thenReturn(resultPasswordValidator);

    this.mockMvc
      .perform(MockMvcRequestBuilders.post(url)
      .contentType(MediaType.APPLICATION_JSON)
      .content(objectMapper.writeValueAsString(validator)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$").value(resultPasswordValidator));


  }



}

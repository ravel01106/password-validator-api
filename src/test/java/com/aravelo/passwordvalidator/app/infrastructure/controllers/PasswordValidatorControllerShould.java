package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;
import com.aravelo.passwordvalidator.app.domain.ports.PasswordValidatedUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
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
    String url = "/app/validate/{password}";
    Validator validator = new Validator(6, true, true, true, true);
    ResultPasswordValidator resultPasswordValidator = new ResultPasswordValidator(true);

    when(passwordValidatedUseCase.validatePassword(password, validator))
      .thenReturn(resultPasswordValidator);

    String validatorJson = objectMapper.writeValueAsString(validator);

    this.mockMvc
      .perform(MockMvcRequestBuilders.post(url, password)
      .contentType(MediaType.APPLICATION_JSON)
      .content(validatorJson))
      .andExpect(MockMvcResultMatchers.status().isOk());


  }



}

package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.aravelo.passwordvalidator.app.domain.models.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordValidatorControllerShould {

  // Permit a password when meet all the conditions
  // Don't permit a password if it does not meet the conditions

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void permitPasswordWhenMeetAllTheConditions() throws Exception{
    String password = "Pepe56789_";
    String url = "/app/validate/{password}";
    Validator validator = new Validator(6, true, true, true, true);

    String validatorJson = objectMapper.writeValueAsString(validator);

    this.mockMvc
      .perform(post(url, password)
      .contentType(MediaType.APPLICATION_JSON)
      .content(validatorJson))
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.valid").value(true))
      .andExpect(jsonPath("$.errorMessage").value(""));

  }

}

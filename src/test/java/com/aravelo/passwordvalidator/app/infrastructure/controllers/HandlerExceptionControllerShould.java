package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class HandlerExceptionControllerShould {
  // Throw error message when send an incomplete body
  // Throw error message when access the wrong path

  @Autowired
  MockMvc mockMvc;

  @Test
  void throwErrorMessageWhenSendAnIncompleteBody() throws Exception {

    this.mockMvc.perform(post("/app/validate/aaaa")
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isBadRequest())
    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.error").value("The body is incomplete !!!"))
    .andExpect(jsonPath("$.errorType").value("INCOMPLETE_BODY"));

  }

  @Test
  void throwErrorMessageWhenAccessTheWrongPath() throws Exception {

    this.mockMvc.perform(post("/app/validate")
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isNotFound())
    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.error").value("This path does not exist !!!"))
    .andExpect(jsonPath("$.errorType").value("FAIL_PATH"));

  }

}

package com.aravelo.passwordvalidator.app.infrastructure.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.aravelo.passwordvalidator.app.domain.ports.ErrorTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ErrorControllerShould {
  // Throw error message when send an incomplete body
  // Throw error message when access the wrong path

  @Autowired
  MockMvc mockMvc;

  @Test
  void throwErrorMessageWhenSendAnIncompleteBody() throws Exception {

    this.mockMvc.perform(post("/app/validate/aaaa")
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isBadRequest())
    .andExpect(jsonPath("$.error").value("Bad Request"))
    .andExpect(jsonPath("$.errorType").value(ErrorTypes.BODY_INCOMPLETE));
  }



}

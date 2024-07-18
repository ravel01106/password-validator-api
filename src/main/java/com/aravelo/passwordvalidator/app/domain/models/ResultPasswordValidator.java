package com.aravelo.passwordvalidator.app.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultPasswordValidator {

  @JsonProperty("valid")
  private boolean valid;

  @JsonProperty("errorMessage")
  private String errorMessage;

  public ResultPasswordValidator(){

  }

  public ResultPasswordValidator(boolean valid, String errorMessage){
    this.valid = valid;
    this.errorMessage = errorMessage;
  }

  public ResultPasswordValidator(boolean isValid){
    this.valid = isValid;
    this.errorMessage = "";
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

}

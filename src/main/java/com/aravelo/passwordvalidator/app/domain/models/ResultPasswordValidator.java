package com.aravelo.passwordvalidator.app.domain.models;

public class ResultPasswordValidator {

  private boolean isValid;
  private String errorMessage;

  public ResultPasswordValidator(){

  }

  public ResultPasswordValidator(boolean isValid, String errorMessage){
    this.isValid = isValid;
    this.errorMessage = errorMessage;
  }

  public ResultPasswordValidator(boolean isValid){
    this.isValid = isValid;
    this.errorMessage = "";
  }

  public boolean isValid() {
    return isValid;
  }

  public void setValid(boolean isValid) {
    this.isValid = isValid;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

}

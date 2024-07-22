package com.aravelo.passwordvalidator.app.domain.models;

import com.aravelo.passwordvalidator.app.domain.ports.ErrorTypes;

public class ErrorDTO {
  private String error;
  private Integer status;
  private String message;
  private ErrorTypes errorType;

  public ErrorDTO() {
    this.errorType = ErrorTypes.UNIDENTIFIED_ERROR;
  }

  public ErrorDTO(String error, Integer status, String message, ErrorTypes errorType) {
    this.error = error;
    this.status = status;
    this.message = message;
    this.errorType = errorType;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorTypes getErrorType() {
    return errorType;
  }

  public void setErrorType(ErrorTypes errorType) {
    this.errorType = errorType;
  }



}

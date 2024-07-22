package com.aravelo.passwordvalidator.app.domain.models;

public class ErrorDTO {
  private String error;
  private Integer status;
  private String message;

  public ErrorDTO() {
  }

  public ErrorDTO(String error, Integer status, String message) {
    this.error = error;
    this.status = status;
    this.message = message;
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

}

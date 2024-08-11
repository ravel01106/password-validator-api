package com.aravelo.passwordvalidator.app.domain.models;

public class Validator {

  private Integer lengthValid;
  private boolean containsUpperCase;
  private boolean containsLowerCase;
  private boolean containsNumber;
  private boolean containsUnderscore;

  public Validator(){
    lengthValid = 0;
    containsLowerCase = false;
    containsNumber = false;
    containsUnderscore = false;
    containsUpperCase = false;
  }

  public Validator(Integer lenghtValid, boolean containsUpperCase, boolean containsLowerCase, boolean containsNumber,
      boolean containUnderscore) {
    this.lengthValid = lenghtValid;
    this.containsUpperCase = containsUpperCase;
    this.containsLowerCase = containsLowerCase;
    this.containsNumber = containsNumber;
    this.containsUnderscore = containUnderscore;
  }

  public Integer getLengthValid() {
    return lengthValid;
  }

  public void setLengthValid(Integer lenghtValid) {
    this.lengthValid = lenghtValid;
  }

  public boolean isContainsUpperCase() {
    return containsUpperCase;
  }

  public void setContainsUpperCase(boolean containsUpperCase) {
    this.containsUpperCase = containsUpperCase;
  }

  public boolean isContainsLowerCase() {
    return containsLowerCase;
  }

  public void setContainsLowerCase(boolean containsLowerCase) {
    this.containsLowerCase = containsLowerCase;
  }

  public boolean isContainsNumber() {
    return containsNumber;
  }

  public void setContainsNumber(boolean containsNumber) {
    this.containsNumber = containsNumber;
  }

  public boolean isContainsUnderscore() {
    return containsUnderscore;
  }

  public void setContainsUnderscore(boolean containUnderscore) {
    this.containsUnderscore = containUnderscore;
  }

}

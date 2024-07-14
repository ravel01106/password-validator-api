package com.aravelo.passwordvalidator.app.domain.models;

public class Validator {

  private Integer lenghtValid;
  private boolean containsUpperCase;
  private boolean containsLowerCase;
  private boolean containsNumber;
  private boolean containUnderscore;

  public Validator(){

  }

  public Validator(Integer lenghtValid, boolean containsUpperCase, boolean containsLowerCase, boolean containsNumber,
      boolean containUnderscore) {
    this.lenghtValid = lenghtValid;
    this.containsUpperCase = containsUpperCase;
    this.containsLowerCase = containsLowerCase;
    this.containsNumber = containsNumber;
    this.containUnderscore = containUnderscore;
  }

  public Integer getLenghtValid() {
    return lenghtValid;
  }

  public void setLenghtValid(Integer lenghtValid) {
    this.lenghtValid = lenghtValid;
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

  public boolean isContainUnderscore() {
    return containUnderscore;
  }

  public void setContainUnderscore(boolean containUnderscore) {
    this.containUnderscore = containUnderscore;
  }

}

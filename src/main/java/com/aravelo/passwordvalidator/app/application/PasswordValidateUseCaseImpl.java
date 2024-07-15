package com.aravelo.passwordvalidator.app.application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;
import com.aravelo.passwordvalidator.app.domain.ports.PasswordValidatedUseCase;

@Service
public class PasswordValidateUseCaseImpl implements PasswordValidatedUseCase{

  @Override
  public ResultPasswordValidator validatePassword(String password, Validator validator) {
    ResultPasswordValidator  resultPasswordValidator = new ResultPasswordValidator(true);
    if (!hasMoreThanEightCharacters(password, validator)){
      resultPasswordValidator.setValid(false);
      resultPasswordValidator.setErrorMessage("The length has to be longer than 8 characters");

    }

    if (!hasUppercase(password)){
      resultPasswordValidator.setValid(false);
      resultPasswordValidator.setErrorMessage("The password must have at least one uppercase");
    }

    if (!hasLowerCase(password)){
      resultPasswordValidator.setValid(false);
      resultPasswordValidator.setErrorMessage("The password must have at least one lowercase");
    }

    if (!hasNumber(password)){
      resultPasswordValidator.setValid(false);
      resultPasswordValidator.setErrorMessage("The password must have at least one number");
    }

    if (!hasUnderscore(password)){
      resultPasswordValidator.setValid(false);
      resultPasswordValidator.setErrorMessage("The password must have at least one underscore");
    }

    return resultPasswordValidator;
  }

  private boolean hasMoreThanEightCharacters(String password, Validator validator) {
    return password.length() >= validator.getLenghtValid();
  }

  private boolean hasUppercase(String password){
    Pattern uppercasePattern = Pattern.compile("[A-Z]");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }

  private boolean hasLowerCase(String password){
    Pattern uppercasePattern = Pattern.compile("[a-z]");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }

  private boolean hasNumber(String password){
    Pattern uppercasePattern = Pattern.compile("[0-9]");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }

  private boolean hasUnderscore(String password){
    Pattern uppercasePattern = Pattern.compile("_");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }

}

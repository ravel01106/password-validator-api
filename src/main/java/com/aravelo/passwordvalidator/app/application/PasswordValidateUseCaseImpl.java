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
    String errorMessage = obtainErrorMessage(password, validator);

    if (!errorMessage.isEmpty()){
      errorMessage = errorMessage.substring(0, (errorMessage.length() - 1));
      resultPasswordValidator.setValid(false);
    }

    resultPasswordValidator.setErrorMessage(errorMessage);

    return resultPasswordValidator;
  }

  private String obtainErrorMessage(String password, Validator validator) {
    String errorMessage = "";

    errorMessage += checkLengthValid(password, validator);
    errorMessage += checkUppercases(password, validator);
    errorMessage += checkLowercases(password, validator);
    errorMessage += checkNumbers(password, validator);
    errorMessage += checkUnderscores(password, validator);

    return errorMessage;
  }


  private boolean hasMoreThanEightCharacters(String password, Validator validator) {
    return password.length() >= validator.getLenghtValid();
  }


  private String checkLengthValid(String password, Validator validator){
    String errorMessage = "";
    if (!hasMoreThanEightCharacters(password, validator)){
      errorMessage = "The length has to be longer than " + validator.getLenghtValid() + " characters\n";
    }
    return errorMessage;
  }


  private boolean hasUppercase(String password){
    Pattern uppercasePattern = Pattern.compile("[A-Z]");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }


  private String checkUppercases(String password, Validator validator){
    String errorMessage = "";
    if (!hasUppercase(password) && validator.isContainsUpperCase()){
      errorMessage = "The password must have at least one uppercase\n";
    }
    return errorMessage;
  }


  private boolean hasLowerCase(String password){
    Pattern uppercasePattern = Pattern.compile("[a-z]");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }


  private String checkLowercases(String password, Validator validator){
    String errorMessage = "";
    if (!hasLowerCase(password) && validator.isContainsLowerCase()){
      errorMessage = "The password must have at least one lowercase\n";
    }
    return errorMessage;
  }


  private boolean hasNumber(String password){
    Pattern uppercasePattern = Pattern.compile("[0-9]");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }


  private String checkNumbers(String password, Validator validator){
    String errorMessage = "";
    if (!hasNumber(password) && validator.isContainsNumber()){
      errorMessage = "The password must have at least one number\n";
    }
    return errorMessage;
  }


  private boolean hasUnderscore(String password){
    Pattern uppercasePattern = Pattern.compile("_");
    Matcher uppercaseMatcher = uppercasePattern.matcher(password);
    return uppercaseMatcher.find();
  }


  private String checkUnderscores(String password, Validator validator){
    String errorMessage = "";
    if (!hasUnderscore(password) && validator.isContainUnderscore()){
      errorMessage = "The password must have at least one underscore\n";
    }
    return errorMessage;
  }


}

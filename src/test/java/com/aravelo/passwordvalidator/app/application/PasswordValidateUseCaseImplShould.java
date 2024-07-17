package com.aravelo.passwordvalidator.app.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;

@SpringBootTest
public class PasswordValidateUseCaseImplShould {

  // Permit a password when meet all the conditions
  // Not permit a password when it doesn't have more than eight characters
  // Not permit a password when it doesn't have uppercase
  // Not permit a password when it doesn't have lowercase
  // Not permit a password when it doesn't have a number
  // Not permit a password when it doesn't have underscore
  // Permit a password when there are no conditions in the validator
  // Get all error messages when password is invalid

  @Autowired
  PasswordValidateUseCaseImpl passwordValidateUseCaseImpl;

  Validator validator = new Validator(8, true,  true, true, true);

  @Test
  void permitPasswordWhenMeetAllTheConditions() {
    String password = "Comida1234_";
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validator);

    assertEquals(true, resultPasswordValidator.isValid());
  }

  @Test
  void notPermitPasswordWhenItDoesNotHaveMoreThanEightCharacters() {
    String password = "Co1_";
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validator);

    assertEquals(false, resultPasswordValidator.isValid());
    assertEquals("The length has to be longer than 8 characters", resultPasswordValidator.getErrorMessage());
  }

  @Test
  void notPermitPasswordWhenItDoesNotHaveUppercase() {
    String password = "comida1234_";
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validator);

    assertEquals(false, resultPasswordValidator.isValid());
    assertEquals("The password must have at least one uppercase", resultPasswordValidator.getErrorMessage());
  }

  @Test
  void notPermitPasswordWhenItDoesNotHaveLowercase() {
    String password = "COMIDA1234_";
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validator);

    assertEquals(false, resultPasswordValidator.isValid());
    assertEquals("The password must have at least one lowercase", resultPasswordValidator.getErrorMessage());
  }

  @Test
  void notPermitPasswordWhenItDoesNotHaveNumber() {
    String password = "COMIDAaa_";
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validator);

    assertEquals(false, resultPasswordValidator.isValid());
    assertEquals("The password must have at least one number", resultPasswordValidator.getErrorMessage());
  }

  @Test
  void notPermitPasswordWhenItDoesNotHaveUnderscore() {
    String password = "Comida1234";
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validator);

    assertEquals(false, resultPasswordValidator.isValid());
    assertEquals("The password must have at least one underscore", resultPasswordValidator.getErrorMessage());
  }

  @Test
  void permitPasswordWhenThereAreNoConditionsInValidator(){
    String password = "";
    Validator validatorWithoutConditions = new Validator();
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validatorWithoutConditions);
    assertEquals(true, resultPasswordValidator.isValid());
    assertEquals("", resultPasswordValidator.getErrorMessage());
  }

  @Test
  void getAllErrorMessagesWhenPasswordIsInvalid() {
    String password = "";
    String errorMessage = "The length has to be longer than 8 characters\n" +
      "The password must have at least one uppercase\n" +
      "The password must have at least one lowercase\n" +
      "The password must have at least one number\n" +
      "The password must have at least one underscore";
    ResultPasswordValidator resultPasswordValidator = passwordValidateUseCaseImpl.validatePassword(password, validator);

    assertEquals(false, resultPasswordValidator.isValid());
    assertEquals(errorMessage, resultPasswordValidator.getErrorMessage());
  }

}

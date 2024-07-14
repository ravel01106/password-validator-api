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
}

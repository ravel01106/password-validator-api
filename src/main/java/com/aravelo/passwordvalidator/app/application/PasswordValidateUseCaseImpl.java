package com.aravelo.passwordvalidator.app.application;

import org.springframework.stereotype.Service;

import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;
import com.aravelo.passwordvalidator.app.domain.ports.PasswordValidatedUseCase;

@Service
public class PasswordValidateUseCaseImpl implements PasswordValidatedUseCase{

  @Override
  public ResultPasswordValidator validatePassword(String password, Validator validator) {
    if (password.length() >= 8){
      return new ResultPasswordValidator(true);
    }
    return new ResultPasswordValidator(false, "the length has to be longer than 8 characters");
  }

}

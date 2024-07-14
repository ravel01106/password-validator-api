package com.aravelo.passwordvalidator.app.domain.ports;

import com.aravelo.passwordvalidator.app.domain.models.ResultPasswordValidator;
import com.aravelo.passwordvalidator.app.domain.models.Validator;

public interface PasswordValidatedUseCase {

  ResultPasswordValidator validatePassword(String password, Validator validator);
}

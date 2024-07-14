package com.aravelo.passwordvalidator.app.domain.ports;

import com.aravelo.passwordvalidator.app.domain.models.Validator;

public interface PasswordValidatedUseCase {
  void validatePassword(String password, Validator validator);
}

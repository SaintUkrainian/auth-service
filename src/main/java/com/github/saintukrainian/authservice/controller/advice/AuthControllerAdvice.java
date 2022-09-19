package com.github.saintukrainian.authservice.controller.advice;

import com.github.saintukrainian.authservice.exception.LoginFailException;
import com.github.saintukrainian.authservice.exception.RegistrationFailException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthControllerAdvice {

  @ExceptionHandler(LoginFailException.class)
  public ResponseEntity<LoginFailException> loginFail(LoginFailException e) {
    return ResponseEntity.badRequest().body(e);
  }

  @ExceptionHandler(RegistrationFailException.class)
  public ResponseEntity<RegistrationFailException> registrationFail(RegistrationFailException e) {
    return ResponseEntity.badRequest().body(e);
  }
}

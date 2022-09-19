package com.github.saintukrainian.authservice.controller;

import com.github.saintukrainian.authservice.model.LoginRequest;
import com.github.saintukrainian.authservice.model.RegistrationRequest;
import com.github.saintukrainian.authservice.model.UserDto;
import com.github.saintukrainian.authservice.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  final UserFacade userFacade;

  @PostMapping("/login")
  public ResponseEntity<UserDto> login(@RequestBody LoginRequest loginRequest) {
    return ResponseEntity.ok(userFacade.findUserByLoginRequest(loginRequest));
  }

  @PostMapping("/register")
  public ResponseEntity<UserDto> register(@RequestBody RegistrationRequest registrationRequest) {
    return ResponseEntity.ok(userFacade.registerNewUser(registrationRequest));
  }
}

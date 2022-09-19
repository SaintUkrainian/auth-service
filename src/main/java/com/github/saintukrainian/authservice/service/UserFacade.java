package com.github.saintukrainian.authservice.service;

import com.github.saintukrainian.authservice.entity.User;
import com.github.saintukrainian.authservice.exception.LoginFailException;
import com.github.saintukrainian.authservice.exception.RegistrationFailException;
import com.github.saintukrainian.authservice.mapper.UserDtoMapper;
import com.github.saintukrainian.authservice.model.LoginRequest;
import com.github.saintukrainian.authservice.model.RegistrationRequest;
import com.github.saintukrainian.authservice.model.UserDto;
import com.github.saintukrainian.authservice.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserFacade {

  final UserRepository userRepository;
  final UserDtoMapper userDtoMapper;

  public UserDto findUserByLoginRequest(LoginRequest request) {
    log.info("Logging in by login request: {}", request);
    User foundUser = userRepository.findByUsernameAndPassword(request.getUsername(),
        request.getPassword());

    if (foundUser == null) {
      throw new LoginFailException("Invalid Username or Password");
    }
    return userDtoMapper.mapToUserDto(foundUser);
  }

  public UserDto registerNewUser(RegistrationRequest registrationRequest) {
    log.info("Registration of a new user by registration request: {}", registrationRequest);

    String email = registrationRequest.getEmail();
    String username = registrationRequest.getUsername();
    if (userRepository.existsByUsernameOrEmail(username, email)) {
      log.warn("User already exists!");
      throw new RegistrationFailException("Username and Email must be unique");
    }

    User user = userRepository.save(User.builder()
        .username(username)
        .password(registrationRequest.getPassword())
        .firstName(registrationRequest.getFirstName())
        .lastName(registrationRequest.getLastName())
        .email(email)
        .build());
    log.info("User has been registered with id: {}", user.getUserId());
    return userDtoMapper.mapToUserDto(user);
  }
}

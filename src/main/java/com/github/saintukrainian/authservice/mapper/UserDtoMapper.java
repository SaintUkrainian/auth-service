package com.github.saintukrainian.authservice.mapper;

import com.github.saintukrainian.authservice.entity.User;
import com.github.saintukrainian.authservice.model.UserDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

  public List<UserDto> mapToUserDtoList(List<User> users) {
    return users.stream()
        .map(this::mapToUserDto)
        .toList();
  }

  public UserDto mapToUserDto(User user) {
    return UserDto.builder()
        .userId(user.getUserId())
        .email(user.getEmail())
        .username(user.getUsername())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .build();
  }
}

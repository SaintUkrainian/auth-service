package com.github.saintukrainian.authservice.model;

import com.github.saintukrainian.authservice.entity.UserImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

  private Long userId;
  private String username;
  private String email;
  private String firstName;
  private String lastName;
  private UserImage userImage;
}

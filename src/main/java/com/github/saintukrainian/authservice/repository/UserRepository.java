package com.github.saintukrainian.authservice.repository;

import com.github.saintukrainian.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsernameAndPassword(String username, String password);
  boolean existsByUsernameOrEmail(String username, String email);
}

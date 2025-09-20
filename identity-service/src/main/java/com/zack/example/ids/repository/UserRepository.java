package com.zack.example.ids.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zack.example.ids.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}

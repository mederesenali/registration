package com.example.registration.repository;

import com.example.registration.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    Boolean existsByEmail(String email);
    User findByEmail(String email);
}

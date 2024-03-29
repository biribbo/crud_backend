package com.example.crudApp.repository;

import com.example.crudApp.model.Role;
import com.example.crudApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    User save(User user);
    List<User> findAllByRole(Role role);
}
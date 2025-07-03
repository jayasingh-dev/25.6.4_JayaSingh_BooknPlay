package com.codewithprojects.springsecurity.repository;

import com.codewithprojects.springsecurity.entities.Role;
import com.codewithprojects.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries if needed
    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);
}

















//import com.codewithprojects.springsecurity.entities.Role;
//import com.codewithprojects.springsecurity.entities.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
////
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//    static Optional<Object> findById(User owner) {
//    }
//
//    Optional<User> findByEmail(String email);
////    User findByRole(Role role);
////    List<User> findByRole(String role);
//    List<User> findByRole(Role role);
//}

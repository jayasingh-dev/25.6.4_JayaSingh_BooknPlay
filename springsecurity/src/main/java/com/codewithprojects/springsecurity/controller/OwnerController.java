// Code Generated by Sidekick is for learning and experimentation purposes only.
package com.codewithprojects.springsecurity.controller;

import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final UserService userService;

    // View own profile
    @GetMapping("/me")
    public ResponseEntity<User> getMyProfile(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getUserByEmail(userDetails.getUsername())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update own profile
    @PutMapping("/me")
    public ResponseEntity<User> updateMyProfile(@AuthenticationPrincipal UserDetails userDetails, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUserByEmail(userDetails.getUsername(), user));
    }
}





















//package com.codewithprojects.springsecurity.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/owner")
//@RequiredArgsConstructor
//public class OwnerController {
//}

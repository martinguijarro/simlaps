package com.simlaps.User;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simlaps.Exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET endpoints

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/user/id/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) throws ResourceNotFoundException {
        return userService.getUserById(userId);
    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) throws ResourceNotFoundException {
        return userService.getUserByUsername(username);
    }

    // CREATE or UPDATE endpoints

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/user/username/{username}/password")
    public ResponseEntity<?> updatePassword(@PathVariable String username, @Valid @RequestBody String oldPassword, @Valid @RequestBody String newPassword) throws ResourceNotFoundException {
        return userService.updatePassword(username, oldPassword, newPassword);
    }

    // DELETE endpoints
    
    @DeleteMapping("/user/id/{userId}/delete")
    public Map<String, Boolean> deleteUserById(@PathVariable String userId) throws ResourceNotFoundException {
        return userService.deleteUserById(userId);
    }

    @DeleteMapping("/user/username/{username}/delete")
    public Map<String, Boolean> deleteUserByUsername(@PathVariable String username) throws ResourceNotFoundException {
        return userService.deleteUserByUsername(username);
    }

}

package com.simlaps.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simlaps.Exception.ResourceNotFoundException;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // GET methods

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserById(String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));

        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> getUserByUsername(String username) throws ResourceNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " not found"));

        return ResponseEntity.ok().body(user);
    }

    // CREATE or UPDATE methods

    public ResponseEntity<User> createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password before saving

        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<?> updatePassword(String username, String oldPassword, String newPassword) throws ResourceNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " not found"));

        boolean passwordMatch = passwordEncoder.matches(oldPassword, user.getPassword());

        if (passwordMatch) {
            user.setPassword(passwordEncoder.encode(newPassword));
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Current password is wrong");
        }
    }

    // DELETE methods

    public Map<String, Boolean> deleteUserById(String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));

        userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("User deleted", Boolean.TRUE);
        
        return response;
    }

    public Map<String, Boolean> deleteUserByUsername(String username) throws ResourceNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " not found"));

        userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("User deletd", Boolean.TRUE);

        return response;
    }

}

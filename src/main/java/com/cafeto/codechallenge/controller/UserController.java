package com.cafeto.codechallenge.controller;

import com.cafeto.codechallenge.exception.ResourceNotFoundException;
import com.cafeto.codechallenge.model.User;
import com.cafeto.codechallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get users
    @GetMapping("users")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    // get user by id
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id)
        throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

                return ResponseEntity.ok().body(user);

    }

    // save user
    @PostMapping("users")
    public User createUser(@RequestBody User user){
        return this.userRepository.save(user);

    }
    // update user
    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") long id,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return ResponseEntity.ok(this.userRepository.save(user));
    }

    // delete user
    @DeleteMapping("users/{id}")
    public Map<String,Boolean> deleteUser(@PathVariable(value = "id") long id,
                                          @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        this.userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }
}

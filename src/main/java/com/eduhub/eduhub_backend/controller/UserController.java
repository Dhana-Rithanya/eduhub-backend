package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.component.User;
import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
    static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(2048,"Dhana","dhana@06"));
        userList.add(new User(459,"Abi","abi@18"));
        userList.add(new User(54,"Divya","54@Di"));
        userList.add(new User(48,"Rithanya","17@dh"));
        userList.add(new User(4,"Shree","006@abi"));
    }
    @GetMapping("user")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid User ID");
        }
        User user = userList.stream()
                .filter(c -> c.getUserId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", "id", String.valueOf(id))
                );

        return ResponseEntity.ok(user);
    }
    @PostMapping
    public ResponseEntity<String> addUser(
            @RequestBody User user) {

        userList.add(user);

        return ResponseEntity.ok("User Added Successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePassword(
            @PathVariable int id,
            @RequestParam String password) {

        User user = userList.stream()
                .filter(c -> c.getUserId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", "id", String.valueOf(id))
                );

        user.setPassword(password);

        return ResponseEntity.ok("Password Updated Successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable int id) {

        User user = userList.stream()
                .filter(c -> c.getUserId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", "id", String.valueOf(id))
                );

        userList.remove(user);

        return ResponseEntity.ok("User Deleted Successfully");
    }
}

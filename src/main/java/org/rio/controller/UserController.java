package org.rio.controller;

import org.rio.entities.User;
import org.rio.interfaces.IUserService;
import org.rio.records.users.CreateUserRequest;
import org.rio.records.users.UpdateUserRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/users")
public class UserController {
    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/v1", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping("/v1/{userId}")
    public User updateUser(@RequestBody UpdateUserRequest request, @PathVariable String userId) {
        return userService.updateUser(userId, request);
    }

    @GetMapping("/v1/get/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }
}

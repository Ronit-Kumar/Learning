package com.example.Learning.controller;

import com.example.Learning.entity.User;
import com.example.Learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/learning")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{email}")
    public String getUserByEmail(
            @PathVariable("email") String emailId) {
        return userService.getUserNameByEmail(emailId);
    }

    @PostMapping("/user")
    public User createNewUser(
            @RequestParam("email") String emailId,
            @RequestParam String firstName,
            @RequestParam String lastName) {
        return userService.createUser(emailId, firstName, lastName);
    }
}

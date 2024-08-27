package com.example.Learning.service.impl;

import com.example.Learning.entity.User;
import com.example.Learning.repositories.UserRepository;
import com.example.Learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String getUserNameByEmail(String email) {
        User user = userRepository.findByEmailId(email).orElse(null);
        return Objects.isNull(user) ? "Invalid Email Id": user.getFirstName().concat(user.getLastname());
    }

    @Override
    public User createUser(String emailId, String firstName, String lastName) {
        return userRepository.save(User.builder()
                        .id(1)
                        .emailId(emailId)
                        .firstName(firstName)
                        .lastname(lastName)
                .build());
    }
}

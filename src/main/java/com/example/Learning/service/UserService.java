package com.example.Learning.service;

import com.example.Learning.entity.User;

public interface UserService {

    String getUserNameByEmail(String email);

    User createUser(String emailId, String firstName, String lastName);
}

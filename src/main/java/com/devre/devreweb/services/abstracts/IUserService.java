package com.devre.devreweb.services.abstracts;

import com.devre.devreweb.entities.User;
import com.devre.devreweb.services.requests.CreateUserRequest;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    void createUser(CreateUserRequest request) throws Exception;
    User getOneUserById(Long userId);
}

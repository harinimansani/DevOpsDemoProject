package com.brillio.service;

import com.brillio.model.User;

public interface UserService {

    User registerUser(User user);

    User editUser(User user);

    User getUser(String email);
}

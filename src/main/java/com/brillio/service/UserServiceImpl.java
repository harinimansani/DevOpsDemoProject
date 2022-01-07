package com.brillio.service;

import com.brillio.model.User;
import com.brillio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        final boolean existsById = this.userRepository.existsById(user.getEmail());
        if (existsById) {
            return null;
        }
        return this.userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        User existsById = this.userRepository.save(user);
        if(existsById!=null){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User getUser(String email) {
        Optional<User> getRegisteredUser = userRepository.findById(email);
        if (getRegisteredUser.isPresent()) {
            return getRegisteredUser.get();
        } else {
            return null;
        }
    }
}

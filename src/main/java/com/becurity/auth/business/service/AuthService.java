package com.becurity.auth.business.service;

import com.becurity.auth.data.entity.User;
import com.becurity.auth.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        Iterable<User> users = this.userRepository.findAll();
        List<User> result = new ArrayList<>();
        if (null != users) {
            users.forEach(user -> {
                result.add(user);
            });
        }
        return result;
    }
    public User getUserWithEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
    }
    public User createUser(String firstName, String lastName, String email, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        return this.userRepository.save(user);
    }
}

package com.becurity.auth.web.service;

import com.becurity.auth.business.service.AuthService;
import com.becurity.auth.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers() {
        return this.authService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{email}/{password}")
    public User getUser(@PathVariable(value = "email")String email, @PathVariable(value = "password")String password) {
        return this.authService.getUserWithEmailAndPassword(email, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public User createUser(
            @RequestParam(value = "firstName")String firstName,
            @RequestParam(value = "lastName")String lastName,
            @RequestParam(value = "email")String email,
            @RequestParam(value = "password")String password) {
        return this.authService.createUser(firstName, lastName, email, password);
    }
}

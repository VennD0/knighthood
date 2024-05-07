package com.knighthood.knighthood.Controller;

import com.knighthood.knighthood.Model.User;
import com.knighthood.knighthood.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserById(@PathVariable("username") String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserLoginRequest userLoginRequest) {
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();

        boolean isAuthenticated = userService.Login(username, password);
        if (isAuthenticated) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/register")
    public boolean createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // @PutMapping("/{id}")
    // public User updateUser(@PathVariable("id") int userId, @RequestBody User user) {
    //     return userService.updateUser(userId, user);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteUser(@PathVariable("id") int userId) {
    //     userService.deleteUser(userId);
    // }

    // Inner class representing the request body for user login
    private static class UserLoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

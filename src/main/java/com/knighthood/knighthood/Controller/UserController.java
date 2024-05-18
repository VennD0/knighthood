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
    public User getUserByusername(@PathVariable("username") String username) {
        return userService.getUserByusername(username);
    }

    @GetMapping("/userid/{userid}")
    public ResponseEntity<User> getUserByUserId(@PathVariable("userid") int id) {
        User user = userService.getUserByuserid(id);
        System.out.println(user.toString());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public LoginRes login(@RequestBody UserLoginRequest userLoginRequest) {
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();

        User user = userService.getUserByusername(username);


        boolean isAuthenticated = userService.Login(username, password);
        return new LoginRes(isAuthenticated, user.getUserid(), user.getUsername());
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

    class LoginRes {
        private boolean status;
        private String username;
        private int user_id;

        public LoginRes(){}

        public LoginRes(boolean status, int user_id, String username){
            this.status = status;
            this.user_id = user_id;
            this.username = username;
        }

        public boolean getStatus(){
            return status;
        }

        public int getUser_id() {
            return user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}

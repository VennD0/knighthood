package com.knighthood.knighthood.Service;

import com.knighthood.knighthood.Model.User;
import com.knighthood.knighthood.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setUser_id(userId); 
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public boolean Login(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        return optionalUser.isPresent(); // Returns true if user exists, false otherwise
    }
}

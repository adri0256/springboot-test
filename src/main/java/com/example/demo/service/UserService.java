package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Users;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private String passwordEncode(String pwd) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return passwordEncoder.encode(pwd);
    }

    public Users addUser(Users user){
        user.setUUID(UUID.randomUUID().toString());
        user.setPassword(passwordEncode(user.getPassword()));

        return userRepo.save(user);
    }

    public List<Users> findAllUsers() {
        return userRepo.findAll();
    }

    public Users updateUser(Users user) {
        return userRepo.save(user);
    }

    public Users findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found") );
    }

    public void deleteUser(Long id) {
        userRepo.deleteUserById(id);
    }
}

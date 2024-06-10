/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.Player;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahmad
 */
@Service
public class UserService {
    
    @Autowired
    UserRepository userRepo;
    
    public void register(String username, String password){
        User user = new User(username, password);
        userRepo.save(user);
    }
    
    
    public User getUser(String username){
        User user = userRepo.findByUsername(username);
        return user;
    }
    
    public boolean usernameAvailable(String username){
        User user = userRepo.findByUsername(username);
        if(user != null){
            return false;
        }else{
            return true;
        }
    }
    
    public void updatePlayer(String username,Player updatedPlayer){
        User user = userRepo.findByUsername(username);
        user.setPlayer(updatedPlayer);
        userRepo.save(user);
    }
    
    public boolean isValid(String username, String password){
        User user = userRepo.findByUsername(username);
        if(user != null && user.getUsername().equals(username) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}

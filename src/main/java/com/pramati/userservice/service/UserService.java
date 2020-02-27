package com.pramati.userservice.service;

import com.pramati.userservice.model.MyUser;
import com.pramati.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<MyUser> getAllUser(){
        return userRepository.findAll();
    }
}

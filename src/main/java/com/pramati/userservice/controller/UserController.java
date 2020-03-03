package com.pramati.userservice.controller;

import com.pramati.userservice.model.MyUser;
import com.pramati.userservice.repository.UserRepository;
import com.pramati.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all")
    public List<MyUser> getAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping("/bookdoctor/{doctorId}")
    public String bookDoctor(@PathVariable("doctorId") int doctorId){
        return restTemplate.getForObject("http://booking-service:8082/doctor/book/"+doctorId,String.class);
    }

    @RequestMapping("/create")
    public List<MyUser> createUser(){
        MyUser myUser = new MyUser(100L,"Pankaj");
        userRepository.save(myUser);
        return getAllUsers();
    }

    @RequestMapping("/test")
    public List<MyUser> testApp(){
        List<MyUser> testUserList = new ArrayList<>();
        testUserList.add(new MyUser(100L,"John"));
        testUserList.add(new MyUser(200L,"Peter"));
        return testUserList;
    }
}
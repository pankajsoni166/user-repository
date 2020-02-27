package com.pramati.userservice.controller;

import com.pramati.userservice.model.MyUser;
import com.pramati.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/all")
    public List<MyUser> getAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping("/bookdoctor/{doctorId}")
    public String bookDoctor(@PathVariable("doctorId") int doctorId){
        return restTemplate.getForObject("http://booking-service/doctor/book/"+doctorId,String.class);
    }
}
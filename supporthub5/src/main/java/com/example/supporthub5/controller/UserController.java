package com.example.supporthub5.controller;


import com.example.supporthub5.model.User;
import com.example.supporthub5.service.UserService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/")
    @ResponseBody
    public String  home() {
        return "WELCOME TO SUPPORT HUB";
    }



    @CrossOrigin("https://localhost:3000")
    @RequestMapping(value="/users" , method=RequestMethod.GET)
    public List<User> getAllSubjects()
    {
        return userService.getAllUsers();
    }


    @CrossOrigin("https://localhost:3000")
    @RequestMapping(method=RequestMethod.POST , value="/register")
    public void UserRegistration(@RequestBody User user)
    {
        userService.UserRegistration(user);
    }



   @CrossOrigin("https://localhost:3000")
    @RequestMapping(method= RequestMethod.PUT , value="/users/{id}")
    public void updateUser(@PathVariable Long id,@RequestBody User user)
    {
        userService.updateUser(id,user);
    }




}

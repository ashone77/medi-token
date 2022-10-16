package com.meditoken.doctorservice.controller;

import com.meditoken.doctorservice.model.User;
import com.meditoken.doctorservice.service.UserService;
import com.meditoken.doctorservice.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "{userId}")
    public User getUserByUserId(@PathVariable("userId") Long userId){
        return userService.getUserByUserId(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userid, @RequestBody User user){
        userService.updateStudent(userid,user);
    }

    @PostMapping(path = "/login")
    public ResponseTemplate login(@RequestBody User user){
        return userService.login(user);
    }

}

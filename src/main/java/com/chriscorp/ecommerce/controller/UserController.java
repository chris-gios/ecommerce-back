package com.chriscorp.ecommerce.controller;

import com.chriscorp.ecommerce.model.User;
import com.chriscorp.ecommerce.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<User> getUserById(@PathVariable(name = "id") long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable(name = "id") long id){
        userService.deleteUserById(id);
    }

    @PostMapping
    @ResponseBody
    private User postUser(@RequestBody User user) throws Exception{
        return userService.create(user);
    }

    @PostMapping("/{id}")
    @ResponseBody
    public User putUser(@RequestBody User user, @PathVariable(name = "id") long id) throws Exception{
        return userService.getUserById(id).map(newObj -> {
            newObj.setUsername(user.getUsername());
            newObj.setEmail(user.getEmail());
            newObj.setPassword(user.getPassword());
            return userService.putUser(newObj);
        }).orElseThrow(() -> new Exception("News with id " + id + "not found"));
    }
}

package com.brillio.controller;

import com.brillio.model.User;
import com.brillio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public User registerUser(@RequestBody User user){
        return this.userService.registerUser(user);
    }

    @GetMapping("findUser/{email}")
    public Object getUserByEmail(@PathVariable("email") String email)  {
        User userEmail= userService.getUser(email);
        if(userEmail!=null){
            return userEmail;
        }
        return "No User Register Found";
    }

    @PutMapping("{email}")
    public Object editUserProfile(@RequestBody User user,@PathVariable("email") String email){
        User editUser= this.userService.editUser(user);
        if(user.getEmail().equals(email)){
            return user;
        }else{
            return "No user Found";
        }
    }
}

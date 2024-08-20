package com.pennywise.PennyWise.controller;

import com.pennywise.PennyWise.entity.SavingsAccount;
import com.pennywise.PennyWise.entity.User;
import com.pennywise.PennyWise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService= userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") int id) {
        Optional<User> user = userService.findUser(id);

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Return a 200 OK with the user's savings accounts if the user is present
        return ResponseEntity.ok(user.get());
    }
}

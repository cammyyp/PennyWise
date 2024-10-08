package com.pennywise.PennyWise.controller.user;

import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        User user = userService.findUser(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);

        return ResponseEntity.ok("User created successfully");
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.createUser(user);

        return ResponseEntity.ok("User updated successfully");
    }
}

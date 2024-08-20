package com.pennywise.PennyWise.service.user;

import com.pennywise.PennyWise.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public User findUser(int id);
}

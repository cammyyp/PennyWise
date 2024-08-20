package com.pennywise.PennyWise.service;

import com.pennywise.PennyWise.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();
    public Optional<User> findUser(int id);
}

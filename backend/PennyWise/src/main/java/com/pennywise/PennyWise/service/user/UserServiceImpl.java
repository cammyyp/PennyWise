package com.pennywise.PennyWise.service.user;

import com.pennywise.PennyWise.dao.user.UserRepository;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.exceptions.DataNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
    }
}

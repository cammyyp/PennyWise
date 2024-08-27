package com.pennywise.PennyWise.service.user;

import com.pennywise.PennyWise.dao.user.UserRepository;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.exceptions.DataNotFoundException;
import com.pennywise.PennyWise.exceptions.DatabaseException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user){
        try {
            user.setCreatedAt(LocalDateTime.now());
            userRepository.save(user);
        } catch (DatabaseException e){
            throw new DatabaseException("Database error", e.getCause());
        }
    }

    @Override
    public User findUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
    }
}

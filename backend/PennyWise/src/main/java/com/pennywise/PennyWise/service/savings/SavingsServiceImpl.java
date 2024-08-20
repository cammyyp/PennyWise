package com.pennywise.PennyWise.service.savings;

import com.pennywise.PennyWise.dao.savings.SavingsRepository;
import com.pennywise.PennyWise.entity.savings.SavingsAccount;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.exceptions.DataNotFoundException;
import com.pennywise.PennyWise.exceptions.DatabaseException;
import com.pennywise.PennyWise.service.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsServiceImpl implements SavingsService{

    private UserService userService;
    private SavingsRepository savingsRepository;

    @Autowired
    public SavingsServiceImpl(SavingsRepository savingsRepository, UserService userService){
        this.savingsRepository= savingsRepository;
        this.userService=userService;
    }

    @Override
    @Transactional
    public List<SavingsAccount> findAllSavingsAccountsForUser(int userId) {
        try {
            User user = userService.findUser(userId);

            List<SavingsAccount> savingsAccounts = savingsRepository.findByUserId(user);

            if(savingsAccounts.isEmpty()){
                throw new DataNotFoundException("No savings found for user");
            }

            return savingsAccounts;
        } catch (DatabaseException e){
            throw new DatabaseException("Database error", e.getCause());
        }
    }

}

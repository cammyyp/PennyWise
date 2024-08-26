package com.pennywise.PennyWise.service.transactions;

import com.pennywise.PennyWise.dao.transactions.TransactionRepository;
import com.pennywise.PennyWise.dao.user.UserRepository;
import com.pennywise.PennyWise.entity.transaction.Transaction;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.enums.TransactionType;
import com.pennywise.PennyWise.service.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    private UserService userService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserService userService){
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Override
    @Transactional
    public List<Transaction> findAllIncomesForUser(int id){
        User user = userService.findUser(id);

        return transactionRepository.findByUserAndTransactionType(user, TransactionType.INCOME);
    }

    @Override
    @Transactional
    public List<Transaction> findAllExpensesForUser(){
        return transactionRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Transaction> findTransaction(int id) {
        return transactionRepository.findById(id);
    }
}

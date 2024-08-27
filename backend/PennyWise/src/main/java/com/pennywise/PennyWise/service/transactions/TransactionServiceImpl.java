package com.pennywise.PennyWise.service.transactions;

import com.pennywise.PennyWise.dao.transactions.TransactionRepository;
import com.pennywise.PennyWise.dao.user.UserRepository;
import com.pennywise.PennyWise.dto.TransactionDto;
import com.pennywise.PennyWise.entity.transaction.Transaction;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.enums.TransactionType;
import com.pennywise.PennyWise.exceptions.DataNotFoundException;
import com.pennywise.PennyWise.exceptions.DatabaseException;
import com.pennywise.PennyWise.service.user.UserService;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    private UserService userService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserService userService){
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Override
    public void createTransaction(TransactionDto transactionDto) {
        try {
            User user = userService.findUser(transactionDto.getUserId());

            Transaction transaction = new Transaction(transactionDto.getAmount(), transactionDto.getTransactionType(), transactionDto.getCategory(), transactionDto.getDueDate(), user);

            transactionRepository.save(transaction);
        } catch (DatabaseException e){
            throw new DatabaseException("Database error", e.getCause());
        }
    }

    @Override
    public void updateTransaction(TransactionDto transactionDto) {
        try {
            Transaction existingTransaction = transactionRepository.findById(transactionDto.getId())
                    .orElseThrow(() -> new DataNotFoundException("Transaction no longer exists"));

            existingTransaction.setAmount(transactionDto.getAmount());
            existingTransaction.setTransactionType(transactionDto.getTransactionType());
            existingTransaction.setCategory(transactionDto.getCategory());
            existingTransaction.setDueDate(transactionDto.getDueDate());

            transactionRepository.save(existingTransaction);
        } catch (DatabaseException e){
            throw new DatabaseException("Database error", e.getCause());
        }
    }

    @Override
    public List<Transaction> findAllIncomesForUser(int userId){
        User user = userService.findUser(userId);

        return transactionRepository.findByUserAndTransactionType(user, TransactionType.INCOME);
    }

    @Override
    public List<Transaction> findAllExpensesForUser(int userId){
        User user = userService.findUser(userId);

        return transactionRepository.findByUserAndTransactionType(user, TransactionType.EXPENSE);
    }
}

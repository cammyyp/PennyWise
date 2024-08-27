package com.pennywise.PennyWise.service.transactions;

import com.pennywise.PennyWise.dto.TransactionDto;
import com.pennywise.PennyWise.entity.transaction.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    public void createTransaction(TransactionDto transactionDto);
    public void updateTransaction(TransactionDto transactionDto);
    public List<Transaction> findAllIncomesForUser(int userId);
    public List<Transaction> findAllExpensesForUser(int userId);
}

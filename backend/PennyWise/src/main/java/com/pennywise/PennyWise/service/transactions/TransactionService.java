package com.pennywise.PennyWise.service.transactions;

import com.pennywise.PennyWise.entity.transaction.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    public List<Transaction> findAllIncomesForUser(int id);
    public List<Transaction> findAllExpensesForUser();
    public Optional<Transaction> findTransaction(int id);
}

package com.pennywise.PennyWise.dao.transactions;

import com.pennywise.PennyWise.entity.transaction.Transaction;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByUserAndTransactionType(User user, TransactionType transactionType);
}

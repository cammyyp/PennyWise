package com.pennywise.PennyWise.service.transactions;

import com.pennywise.PennyWise.dao.transactions.TransactionRepository;
import com.pennywise.PennyWise.entity.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Transaction> findTransaction(int id) {
        return transactionRepository.findById(id);
    }
}

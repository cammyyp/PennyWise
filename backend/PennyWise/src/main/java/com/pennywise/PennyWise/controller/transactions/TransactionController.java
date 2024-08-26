package com.pennywise.PennyWise.controller.transactions;

import com.pennywise.PennyWise.entity.transaction.Transaction;
import com.pennywise.PennyWise.service.transactions.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{userId}/incomes")
    public List<Transaction> getUserIncomes(@PathVariable int userId){
        return transactionService.findAllIncomesForUser(userId);
    }
}

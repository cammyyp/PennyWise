package com.pennywise.PennyWise.controller.transactions;

import com.pennywise.PennyWise.dto.TransactionDto;
import com.pennywise.PennyWise.entity.transaction.Transaction;
import com.pennywise.PennyWise.service.transactions.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}/expenses")
    public List<Transaction> getUserExpenses(@PathVariable int userId){
        return transactionService.findAllExpensesForUser(userId);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> createTransaction(@RequestBody TransactionDto transactionDto){
        transactionService.createTransaction(transactionDto);

        return ResponseEntity.ok("transaction added successfully");
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateTransaction(@RequestBody TransactionDto transactionDto){
        transactionService.updateTransaction(transactionDto);

        return ResponseEntity.ok("transaction updated successfully");
    }
}

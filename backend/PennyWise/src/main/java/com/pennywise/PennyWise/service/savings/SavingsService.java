package com.pennywise.PennyWise.service.savings;

import com.pennywise.PennyWise.entity.savings.SavingsAccount;
import com.pennywise.PennyWise.entity.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface SavingsService {

    public List<SavingsAccount> findAllSavingsAccountsForUser(int id);
}

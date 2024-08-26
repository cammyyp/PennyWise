package com.pennywise.PennyWise.service.savings;

import java.util.List;
import com.pennywise.PennyWise.dto.SavingsAccountDto;
import com.pennywise.PennyWise.entity.savings.SavingsAccount;


public interface SavingsService {

    public List<SavingsAccountDto> findAllSavingsAccountsForUser(int userId);

    public void createSavingsAccount(SavingsAccountDto savingsAccount);

    public void updateSavingsAccount(SavingsAccountDto savingsAccount);
    public void removeSavingsAccount(int id);
}

package com.pennywise.PennyWise.service.savings;

import com.pennywise.PennyWise.dao.savings.SavingsRepository;
import com.pennywise.PennyWise.dto.SavingsAccountDto;
import com.pennywise.PennyWise.entity.savings.SavingsAccount;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.exceptions.DataNotFoundException;
import com.pennywise.PennyWise.exceptions.DatabaseException;
import com.pennywise.PennyWise.service.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SavingsServiceImpl implements SavingsService{

    private UserService userService;
    private SavingsRepository savingsRepository;

    @Autowired
    public SavingsServiceImpl(SavingsRepository savingsRepository, UserService userService){
        this.savingsRepository= savingsRepository;
        this.userService=userService;
    }

    @Override
    @Transactional
    public List<SavingsAccountDto> findAllSavingsAccountsForUser(int userId) {
        try {
            User user = userService.findUser(userId);

            List<SavingsAccount> savingsAccounts = savingsRepository.findByUser(user);

            if(savingsAccounts.isEmpty()){
                throw new DataNotFoundException("No savings found for user");
            }

            return savingsAccounts.stream().map(SavingsAccountDto::new).toList();
        } catch (DatabaseException e){
            throw new DatabaseException("Database error", e.getCause());
        }
    }

    @Override
    @Transactional
    public void createSavingsAccount(SavingsAccountDto savingsAccountDto) {
        try {
            User user = userService.findUser(savingsAccountDto.getUserId());

            SavingsAccount savingsAccount = new SavingsAccount(savingsAccountDto.getAccountName(), savingsAccountDto.getValue(), savingsAccountDto.getRiskCategory(), savingsAccountDto.getDescription(), user);

            savingsRepository.save(savingsAccount);
        } catch (DatabaseException e){
            throw new DatabaseException("Database error", e.getCause());
        }
    }

    @Override
    @Transactional
    public void updateSavingsAccount(SavingsAccountDto savingsAccount) {
        try {
            SavingsAccount existingSavingsAccount = savingsRepository.findById(savingsAccount.getId())
                    .orElseThrow(() -> new DataNotFoundException("Savings account no longer exists"));

            existingSavingsAccount.setAccountName(savingsAccount.getAccountName());
            existingSavingsAccount.setValue(savingsAccount.getValue());
            existingSavingsAccount.setRiskCategory(savingsAccount.getRiskCategory());
            existingSavingsAccount.setDescription(savingsAccount.getDescription());

            savingsRepository.save(existingSavingsAccount);

        } catch(DatabaseException e){
            throw new DatabaseException("Database error", e.getCause());
        }
    }

    @Override
    @Transactional
    public void removeSavingsAccount(int id){
        try {
            SavingsAccount existingSavingsAccount = savingsRepository.findById(id)
                    .orElseThrow(() -> new DataNotFoundException("Savings account no longer exists"));

            savingsRepository.delete(existingSavingsAccount);
        }catch (DatabaseException e) {
            throw new DatabaseException("Database error", e.getCause());
        }
    }
}

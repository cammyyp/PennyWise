package com.pennywise.PennyWise.controller.savings;

import com.pennywise.PennyWise.dto.SavingsAccountDto;
import com.pennywise.PennyWise.entity.savings.SavingsAccount;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.service.savings.SavingsService;
import com.pennywise.PennyWise.service.savings.SavingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    private SavingsService savingsService;

    @Autowired
    public SavingsController(SavingsService savingsService){this.savingsService = savingsService;}

    @GetMapping("/user/{userid}")
    public List<SavingsAccountDto> getUserSavingsAccounts(@PathVariable(name = "userid") int userId){
        return savingsService.findAllSavingsAccountsForUser(userId);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> createUserSavingsAccount(@RequestBody SavingsAccountDto savingsAccount) {
        savingsService.createSavingsAccount(savingsAccount);

        return ResponseEntity.ok("Savings account added successfully");
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateUserSavingsAccount( @RequestBody SavingsAccountDto savingsAccount) {
        savingsService.updateSavingsAccount(savingsAccount);

        return ResponseEntity.ok("Savings account updated successfully");
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteUserSavingsAccount(@PathVariable int id) {
        savingsService.removeSavingsAccount(id);

        return ResponseEntity.ok("Savings account deleted successfully");
    }
}

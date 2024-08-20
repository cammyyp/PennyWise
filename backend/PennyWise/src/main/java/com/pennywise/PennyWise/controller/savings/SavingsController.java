package com.pennywise.PennyWise.controller.savings;

import com.pennywise.PennyWise.entity.savings.SavingsAccount;
import com.pennywise.PennyWise.service.savings.SavingsService;
import com.pennywise.PennyWise.service.savings.SavingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    private SavingsService savingsService;

    @Autowired
    public SavingsController(SavingsService savingsService){this.savingsService = savingsService;}

    @GetMapping("/user/{id}")
    public List<SavingsAccount> getUserSavingsAccounts(@PathVariable int id){
        return savingsService.findAllSavingsAccountsForUser(id);
    }
}

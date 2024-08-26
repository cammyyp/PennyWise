package com.pennywise.PennyWise.dto;

import com.pennywise.PennyWise.entity.savings.SavingsAccount;
import com.pennywise.PennyWise.enums.RiskCategory;

public class SavingsAccountDto {

    private int id;
    private String accountName;

    private int value;

    private RiskCategory riskCategory;

    private String description;

    private int userId;

    public SavingsAccountDto() {
    }

    public SavingsAccountDto(SavingsAccount savingsAccount) {
        this.id = savingsAccount.getId();
        this.accountName = savingsAccount.getAccountName();
        this.value = savingsAccount.getValue();
        this.riskCategory = savingsAccount.getRiskCategory();
        this.description = savingsAccount.getDescription();
        this.userId = savingsAccount.getUser().getId();
    }

    public SavingsAccountDto(int id, String accountName, int value, RiskCategory riskCategory, String description, int userId) {
        this.id = id;
        this.accountName = accountName;
        this.value = value;
        this.riskCategory = riskCategory;
        this.description = description;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RiskCategory getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(RiskCategory riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

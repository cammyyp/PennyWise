package com.pennywise.PennyWise.entity.savings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.pennywise.PennyWise.entity.BaseEntity;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.enums.RiskCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "savings")
public class SavingsAccount extends BaseEntity {

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "value")
    private int value;

    @Enumerated(EnumType.STRING)
    @Column(name = "risk_category")
    private RiskCategory riskCategory;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public SavingsAccount() {
    }

    public SavingsAccount(String accountName, int value, RiskCategory riskCategory, String description, User user) {
        this.accountName = accountName;
        this.value = value;
        this.riskCategory = riskCategory;
        this.description = description;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

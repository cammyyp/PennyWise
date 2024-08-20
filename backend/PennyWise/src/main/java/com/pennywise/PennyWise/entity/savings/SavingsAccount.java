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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User userId;

    public SavingsAccount() {
    }

    public SavingsAccount(String accountName, int value, RiskCategory riskCategory, String description, User userId) {
        this.accountName = accountName;
        this.value = value;
        this.riskCategory = riskCategory;
        this.description = description;
        this.userId = userId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}

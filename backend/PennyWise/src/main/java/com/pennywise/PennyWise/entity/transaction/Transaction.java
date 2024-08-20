package com.pennywise.PennyWise.entity.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pennywise.PennyWise.entity.BaseEntity;
import com.pennywise.PennyWise.entity.user.User;
import com.pennywise.PennyWise.enums.TransactionType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Column(name = "amount")
    private float amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionType transactionType;

    @Column(name = "category")
    private String category;

    @Column(name = "date_due")
    private Date dueDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User userId;

    public Transaction() {}

    public Transaction(float amount, TransactionType transactionType, String category, Date dueDate, User userId) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.category = category;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}

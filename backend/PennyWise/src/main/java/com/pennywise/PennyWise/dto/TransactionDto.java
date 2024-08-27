package com.pennywise.PennyWise.dto;

import com.pennywise.PennyWise.entity.transaction.Transaction;
import com.pennywise.PennyWise.enums.TransactionType;

import java.util.Date;

public class TransactionDto {

    private int id;
    private float amount;

    private TransactionType transactionType;

    private String category;

    private Date dueDate;

    private int userId;

    public TransactionDto() {
    }

    public TransactionDto(Transaction transaction) {
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.transactionType = transaction.getTransactionType();
        this.category = transaction.getCategory();
        this.dueDate = transaction.getDueDate();
        this.userId = transaction.getUser().getId();
    }

    public TransactionDto(int id, float amount, TransactionType transactionType, String category, Date dueDate, int userId) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.category = category;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

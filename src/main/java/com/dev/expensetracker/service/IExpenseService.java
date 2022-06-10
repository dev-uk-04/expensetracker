package com.dev.expensetracker.service;

import java.util.List;

import com.dev.expensetracker.entity.Expense;

public interface IExpenseService {
    
    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);
}

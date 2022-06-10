package com.dev.expensetracker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dev.expensetracker.entity.Expense;

public interface IExpenseService {
    
    Page<Expense> getAllExpenses(Pageable page);

    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);
}

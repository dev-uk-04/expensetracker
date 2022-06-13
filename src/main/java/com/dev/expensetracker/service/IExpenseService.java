package com.dev.expensetracker.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dev.expensetracker.entity.Expense;

public interface IExpenseService {
    
    Page<Expense> getAllExpenses(Pageable page);

    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);

    List<Expense> readByCategory(String category, Pageable page);

    List<Expense> readByName(String name, Pageable page);

    List<Expense> readByDate(Date startDate, Date endDate, Pageable page);
}

package com.dev.expensetracker.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.expensetracker.entity.Expense;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense, Long>{
    
    // SELECT * FROM tbl_expenses WHERE category := category;
    Page<Expense> findByCategory(String category, Pageable page); 

    Page<Expense> findByNameContaining(String keyword, Pageable page);

    Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);
}

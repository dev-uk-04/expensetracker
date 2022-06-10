package com.dev.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.expensetracker.entity.Expense;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense, Long>{
    
}

package com.dev.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.expensetracker.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    
    boolean existsByEmail(String email);
}

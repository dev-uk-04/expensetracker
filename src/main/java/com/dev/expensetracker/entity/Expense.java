package com.dev.expensetracker.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "expense_name")
    @NotNull(message = "Expense name must not be null")
    @Size(message = "Expense name must be of atleast 3 characters")
    private String name;

    private String description;

    @Column(name = "expense_amount")
    @NotNull(message = "Expense amount can not be null")
    private BigDecimal amount;

    @NotNull(message = "Category can not be null")
    private String category;

    @NotNull(message = "Date can not be null")
    private Date date;

    @Column(name = "created_time", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdTime;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private Timestamp updatedTime;

}

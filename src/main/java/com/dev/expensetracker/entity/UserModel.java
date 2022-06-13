package com.dev.expensetracker.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class UserModel {
    
    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Email should not be empty")
    @Email(message = "Enter valid email")
    private String email;

    @NotNull(message = "Password should not be empty")
    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    private Long age = 0L;
}

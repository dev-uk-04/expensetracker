package com.dev.expensetracker.entity;

import lombok.Data;

@Data
public class ErrorObject {

    private Integer statusCode;

    private String message;

    private Long timestamp;
    
}

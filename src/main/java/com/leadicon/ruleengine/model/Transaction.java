package com.leadicon.ruleengine.model;

import lombok.Data;

@Data
public class Transaction {
    private int id;
    private double amount;
    private String type;
    private String category;
}

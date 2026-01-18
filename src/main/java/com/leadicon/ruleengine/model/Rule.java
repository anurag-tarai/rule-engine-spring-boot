package com.leadicon.ruleengine.model;

import lombok.Data;

@Data
public class Rule {
    private String condition;
    private boolean active = true;
}

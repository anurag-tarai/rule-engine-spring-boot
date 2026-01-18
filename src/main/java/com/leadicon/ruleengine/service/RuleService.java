package com.leadicon.ruleengine.service;

import com.leadicon.ruleengine.model.Rule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleService {

    private final List<Rule> rules = new ArrayList<>();

    public void addRules(List<Rule> newRules) {
        rules.addAll(newRules);
    }

    public List<Rule> getActiveRules() {
        return rules.stream()
                .filter(Rule::isActive)
                .toList();
    }
}

package com.leadicon.ruleengine.service;

import com.leadicon.ruleengine.model.Rule;
import com.leadicon.ruleengine.model.Transaction;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluationService {

    private final RuleService ruleService;
    private final ScriptEngine engine;

    public EvaluationService(RuleService ruleService) {
        this.ruleService = ruleService;
        this.engine = new ScriptEngineManager().getEngineByName("js");
    }

    public List<Transaction> evaluate(List<Transaction> transactions) {

        List<Transaction> matchedTransactions = new ArrayList<>();

        for (Transaction tx : transactions) {
            for (Rule rule : ruleService.getActiveRules()) {

                if (evaluateRule(rule.getCondition(), tx)) {
                    matchedTransactions.add(tx);
                    break; // match at least one rule
                }
            }
        }
        return matchedTransactions;
    }

    private boolean evaluateRule(String condition, Transaction tx) {
        try {
            engine.put("amount", tx.getAmount());
            engine.put("type", tx.getType());
            engine.put("category", tx.getCategory());

            return (Boolean) engine.eval(condition);

        } catch (Exception e) {
            return false;
        }
    }
}

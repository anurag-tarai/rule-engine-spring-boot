package com.leadicon.ruleengine.controller;

import com.leadicon.ruleengine.model.Transaction;
import com.leadicon.ruleengine.service.EvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluate")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping
    public List<Transaction> evaluate(@RequestBody List<Transaction> transactions) {
        return evaluationService.evaluate(transactions);
    }
}

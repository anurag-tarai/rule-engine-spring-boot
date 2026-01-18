package com.leadicon.ruleengine.controller;

import com.leadicon.ruleengine.model.Rule;
import com.leadicon.ruleengine.service.RuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public String addRules(@RequestBody List<Rule> rules) {
        ruleService.addRules(rules);
        return "Rules added successfully";
    }

    @GetMapping
    public List<Rule> getRules() {
        return ruleService.getActiveRules();
    }
}

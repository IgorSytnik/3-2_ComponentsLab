package com.company.controllers.commands;

import com.company.models.StackInt;
import com.company.services.StackService;

public class TestProxy extends Command {

    private final StackInt stack;

    public TestProxy(StackService stackService, StackInt stack) {
        this.stackService = stackService;
        this.stack = stack;
    }

    public String execute() {
        return stackService.testProxy(stack);
    }
}

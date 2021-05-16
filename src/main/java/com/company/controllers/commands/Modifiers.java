package com.company.controllers.commands;

import com.company.services.StackService;

public class Modifiers extends Command {

    private final Class cl;

    public Modifiers(StackService stackService, Class cl) {
        this.stackService = stackService;
        this.cl = cl;
    }

    public String execute() {
        return stackService.getModifiers(cl);
    }
}

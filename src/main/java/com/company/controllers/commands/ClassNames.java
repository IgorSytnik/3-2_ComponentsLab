package com.company.controllers.commands;

import com.company.services.StackService;

public class ClassNames extends Command {

    private final Class cl;

    public ClassNames(StackService stackService, Class cl) {
        this.stackService = stackService;
        this.cl = cl;
    }

    public String execute() {
        return stackService.getClSuperClNames(cl);
    }
}

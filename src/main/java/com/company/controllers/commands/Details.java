package com.company.controllers.commands;

import com.company.services.StackService;

public class Details extends Command {

    private final Class cl;

    public Details(StackService stackService, Class cl) {
        this.stackService = stackService;
        this.cl = cl;
    }

    public String execute() {
        return stackService.getDetails(cl);
    }
}

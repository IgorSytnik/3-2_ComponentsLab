package com.company.controllers.commands;

import com.company.models.StackInt;
import com.company.services.StackService;

import java.lang.reflect.InvocationTargetException;

public class AnoInvoke extends Command {

    private final Class cl;
    private final Class anotation;
    private final StackInt stack;

    public AnoInvoke(StackService stackService, Class cl, Class anotation, StackInt stack) {
        this.stackService = stackService;
        this.cl = cl;
        this.anotation = anotation;
        this.stack = stack;
    }

    public String execute() throws InvocationTargetException, IllegalAccessException {
        return stackService.invokeByAnnotation(cl.getMethods(), anotation, stack);
    }
}

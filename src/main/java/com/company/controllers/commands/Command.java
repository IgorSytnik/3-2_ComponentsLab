package com.company.controllers.commands;

import com.company.services.StackService;

import java.lang.reflect.InvocationTargetException;

public abstract class Command {

    protected StackService stackService;

    public abstract String execute() throws InvocationTargetException, IllegalAccessException;
}

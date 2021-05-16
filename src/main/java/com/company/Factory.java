package com.company;

import com.company.controllers.StackController;
import com.company.services.StackService;
import com.company.services.StackServiceImpl;
import com.company.view.decorators.ControllerDecorator;
import com.company.view.decorators.DecoratorStripes;

/*
Factory
 */
public class Factory {

//    public static ControllerDecorator crateControllerDecorator() {
//        return new DecoratorStripes(crateStackController());
//    }
//
//    public static StackController crateStackController() {
//        return new StackController(crateStackService());
//    }
//
//    public static StackService crateStackService() {
//        return StackServiceImpl.getInstance();
//    }
}

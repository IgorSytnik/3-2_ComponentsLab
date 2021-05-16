package com.company.view.decorators;

import com.company.controllers.StackController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DecoratorStripes implements ControllerDecorator {

    @Autowired
    StackController stackController;

    public DecoratorStripes(StackController stackController) {
        this.stackController = stackController;
    }

    public String show(int option) throws InvocationTargetException, IllegalAccessException {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            str1.append("-");
        }
        for (int i = 0; i < 20; i++) {
            str2.append("=");
        }
        return str1.toString() + "\n" + stackController.menu(option) + "\n" + str2.toString();
    }
}

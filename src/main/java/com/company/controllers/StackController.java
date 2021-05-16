package com.company.controllers;

import com.company.controllers.commands.*;
import com.company.models.*;
import com.company.models.memento.Snapshot;
import com.company.models.memento.SnapshotStack;
import com.company.services.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;

/*
Command - controller
Singleton - service
Memento - Stack
Factory - Factory (controller, service, decorator)
Decorator - for controller in view
 */
/*
Command
Decorator
 */
@Controller
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StackController {

    @Autowired
    StackService stackService;
    final Class cl;
    final StackInt stack;

    public StackController(StackService stackService) {
        this.stackService = stackService;
        cl = Stack.class;
        stack = new Stack(5);

        stack.push(1);
        stack.push(2);
    }

    public String menu(int option)
            throws InvocationTargetException, IllegalAccessException, RuntimeException {
        Command command;
        Snapshot snapshot = new SnapshotStack((Stack) stack, stack.getArray(), stack.size(), stack.capacity());

        switch (option) {
            case 1:
                command = new ClassNames(stackService, cl);
                break;
            case 2:
                stack.push(3);
                command = new AnoInvoke(stackService, cl, ano.class, stack);
                break;
            case 3:
                command = new Details(stackService, cl);
                break;
            case 4:
                command = new Modifiers(stackService, cl);
                break;
            case 5:
                stack.push(3);
                command = new TestProxy(stackService, stack);
                break;
            default:
                throw new RuntimeException("Wrong menu option");
        }

        String str = command.execute();
        snapshot.restore();
        return str;
    }
}

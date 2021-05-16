package com.company.view.decorators;

import java.lang.reflect.InvocationTargetException;

public interface ControllerDecorator {
    String show(int option) throws InvocationTargetException, IllegalAccessException;
}

package com.company.services;

import com.company.models.StackInt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface StackService {
    String testProxy (StackInt ob);
    String getModifiers (Class cl);
    String getClSuperClNames (Class cl);
    String invokeByAnnotation (Method[] methods, Class annotationClass, Object ob)
            throws InvocationTargetException, IllegalAccessException ;
    String getDetails (Class c);
}

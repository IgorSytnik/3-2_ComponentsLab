package com.company.services;

import com.company.models.Proxy;
import com.company.models.StackInt;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
Singleton
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StackServiceImpl implements StackService {

    //
//    private static StackService stackService;
//
//    public static StackService getInstance() {
//        if (stackService == null) {
//            stackService = new StackServiceImpl();
//        }
//        return stackService;
//    }
    //

    public String testProxy (StackInt ob) {
        StringBuilder str = new StringBuilder();
        StackInt proxy = (StackInt)  Proxy.newProxyInstance(ob);
        str.append(proxy.pop()).append('\n');
        try {
            proxy.push(42);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public String getModifiers (Class cl) {
        return Modifier.toString(cl.getModifiers());
    }

    public String getClSuperClNames (Class cl) {
        return "Class name: " + cl.getName() + '\n' +
                "Superclass name: " + cl.getSuperclass().getName() + '\n';
    }

    public String invokeByAnnotation (Method[] methods, Class annotationClass, Object ob)
            throws InvocationTargetException, IllegalAccessException {
        StringBuilder str = new StringBuilder();
        for (Method m : methods) {
            if (m.isAnnotationPresent(annotationClass)) str.append(m.invoke(ob)).append('\n');
        }
        return str.toString();
    }

    public String getDetails (Class c) {
        StringBuilder str = new StringBuilder();
        Method[] methods = c.getMethods();
        str.append("Class name: ").append(c.getName()).append('\n');
        str.append("Superclass name: ").append(c.getSuperclass().getName()).append('\n');

        for (Method m : methods) {
            str.append('\n').append(m.getName()).append(':').append('\n');
            str.append("Modifiers: ");
            str.append(Modifier.toString(m.getModifiers()));
            Class[] param = m.getParameterTypes();
            if (param.length != 0) {
                str.append('\n').append("Parameter types: ");
                str.append(param[0].getName());
                for (int i = 1; i < param.length; i++) {
                    str.append(", ").append(param[i].getName());
                }
            }
            str.append('\n');
        }
        return str.toString();
    }
}

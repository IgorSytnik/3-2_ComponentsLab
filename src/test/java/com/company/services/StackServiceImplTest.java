package com.company.services;

import com.company.models.Stack;
import com.company.models.ano;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class StackServiceImplTest {

    StackServiceImpl stackService = new StackServiceImpl();

    @Test
    void testProxy() {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        assertEquals( "2\n",
                stackService.testProxy(stack));
    }

    @Test
    void getModifiers() {
        assertEquals( "public",
                stackService.getModifiers(Stack.class));
    }

    @Test
    void getClSuperClNames() {
        assertEquals( "Class name: com.company.models.Stack\n" +
                        "Superclass name: java.lang.Object\n",
                stackService.getClSuperClNames(Stack.class));
    }

    @Test
    void invokeByAnnotation() throws InvocationTargetException, IllegalAccessException {
        Stack stack = new Stack(5);

        stack.push(3);

        Method[] methods = Stack.class.getMethods();
        assertEquals( "false\n" +
                        "3\n",
                stackService.invokeByAnnotation(methods, ano.class, stack));
    }

    @Test
    void getDetails() {
        assertEquals( "Class name: com.company.models.Stack\n" +
                        "Superclass name: java.lang.Object\n" +
                        "\n" +
                        "toString:\n" +
                        "Modifiers: public\n" +
                        "\n" +
                        "isEmpty:\n" +
                        "Modifiers: public\n" +
                        "\n" +
                        "size:\n" +
                        "Modifiers: public\n" +
                        "\n" +
                        "capacity:\n" +
                        "Modifiers: public\n" +
                        "\n" +
                        "getArray:\n" +
                        "Modifiers: public\n" +
                        "\n" +
                        "push:\n" +
                        "Modifiers: public\n" +
                        "Parameter types: int\n" +
                        "\n" +
                        "pop:\n" +
                        "Modifiers: public\n" +
                        "\n" +
                        "setState:\n" +
                        "Modifiers: public\n" +
                        "Parameter types: [I, int, int\n" +
                        "\n" +
                        "wait:\n" +
                        "Modifiers: public final native\n" +
                        "Parameter types: long\n" +
                        "\n" +
                        "wait:\n" +
                        "Modifiers: public final\n" +
                        "Parameter types: long, int\n" +
                        "\n" +
                        "wait:\n" +
                        "Modifiers: public final\n" +
                        "\n" +
                        "equals:\n" +
                        "Modifiers: public\n" +
                        "Parameter types: java.lang.Object\n" +
                        "\n" +
                        "hashCode:\n" +
                        "Modifiers: public native\n" +
                        "\n" +
                        "getClass:\n" +
                        "Modifiers: public final native\n" +
                        "\n" +
                        "notify:\n" +
                        "Modifiers: public final native\n" +
                        "\n" +
                        "notifyAll:\n" +
                        "Modifiers: public final native\n",
                stackService.getDetails(Stack.class));
    }
}
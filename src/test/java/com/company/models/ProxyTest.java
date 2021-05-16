package com.company.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProxyTest {

    Proxy proxy;
    StackInt stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(2);
        stack.push(1);
        stack.push(2);
    }

    @Test
    void invoke_InvokeInterceptedMethod_Equals() {
        StackInt proxy = (StackInt) Proxy.newProxyInstance(stack);
        assertEquals(2, proxy.pop());
    }

    @Test
    void invoke_InvokeInterceptedMethod_UndeclaredThrowableException_causedBy_IllegalAccessException() {
        StackInt proxy = (StackInt) Proxy.newProxyInstance(stack);
        Throwable t = assertThrows(java.lang.reflect.UndeclaredThrowableException.class, () -> proxy.push(2));
        assertEquals(IllegalAccessException.class, t.getCause().getClass());
    }

    @Test
    void newProxyInstance() {
        assertTrue(Proxy.newProxyInstance(stack) instanceof StackInt);
    }
}
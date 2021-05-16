package com.company.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack stack;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void push_AnInteger_Equals() {
        stack = new Stack(2);
        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    void push_With0Cap_RuntimeException() {
        stack = new Stack(0);
        assertThrows(RuntimeException.class, () -> stack.push(1));
    }

    @Test
    void push_OverTheCap_RuntimeException() {
        stack = new Stack(1);
        stack.push(1);
        assertThrows(RuntimeException.class, () -> stack.push(2));
    }

    @Test
    void pop_TwiceWithTwoElements_Equals() {
        stack = new Stack(2);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void pop_TwiceWithOneElement_RuntimeException() {
        stack = new Stack(1);
        stack.push(1);
        stack.pop();
        assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    void pop_WithNoElements_RuntimeException() {
        stack = new Stack(0);
        assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    void size_TestingSizeMethod() {
        stack = new Stack(3);
        stack.push(1);
        assertEquals(1, stack.size());
        assertNotEquals(0, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void capacity_0Cap_Equals() {
        stack = new Stack(0);
        assertEquals(0, stack.capacity());
        assertNotEquals(2, stack.size());
    }

    @Test
    void capacity_2Cap_Equals() {
        stack = new Stack(2);
        assertEquals(2, stack.capacity());
        assertNotEquals(1, stack.size());
    }

    @Test
    void isEmpty_EmptyStack_True() {
        stack = new Stack(1);
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmpty_NotEmptyStack_False() {
        stack = new Stack(1);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
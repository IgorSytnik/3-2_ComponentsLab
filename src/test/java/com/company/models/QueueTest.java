package com.company.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @Test
    void pop_TwiceWithTwoElements_Equals() {
        queue = new Queue(2);
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
    }

    @Test
    void pop_TwiceWithOneElement_RuntimeException() {
        queue = new Queue(1);
        queue.push(1);
        queue.pop();
        assertThrows(RuntimeException.class, () -> queue.pop());
    }

    @Test
    void pop_WithNoElements_RuntimeException() {
        queue = new Queue(0);
        assertThrows(RuntimeException.class, () -> queue.pop());
    }
}
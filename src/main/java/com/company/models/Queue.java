package com.company.models;

public class Queue extends Stack {
    public Queue(int capacity) {
        super(capacity);
    }

    @Override
    public int pop() throws RuntimeException {
        if (count == 0) throw new RuntimeException("Storage is empty");
        int toRemove = array[0];
        if (count - 1 > 0) System.arraycopy(array, 1, array, 0, count - 1);
        array[count - 1] = '\0';
        count--;
        return toRemove;
    }
}

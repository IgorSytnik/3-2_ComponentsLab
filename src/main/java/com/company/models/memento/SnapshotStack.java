package com.company.models.memento;

import com.company.models.Stack;

public class SnapshotStack implements Snapshot {

    private Stack stack;
    private int[] array;
    private int count;
    private int capacity;

    public SnapshotStack(Stack stack, int[] array, int count, int capacity) {
        this.stack = stack;
        this.array = array;
        this.count = count;
        this.capacity = capacity;
    }

    @Override
    public void restore() {
        stack.setState(array, count, capacity);
    }
}

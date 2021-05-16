package com.company.models;

/*
Memento
 */
public class Stack implements StackInt {
    protected int[] array;
    protected int count = 0;
    protected int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.array = new int [capacity];
    }

    public void setState(int[] array, int count, int capacity) {
        this.array = array;
        this.count = count;
        this.capacity = capacity;
    }

    public void push(int element) throws RuntimeException {
        if (count >= capacity) throw new RuntimeException("Storage is full");
        array[count] = element;
        count++;
    }

    @ano
    public int pop() throws RuntimeException {
        if (count == 0) throw new RuntimeException("Storage is empty");
        int toRemove = array[count - 1];
        array[count - 1] = '\0';
        count--;
        return toRemove;
    }

    public int size() {
        return count;
    }

    public int capacity() {
        return capacity;
    }

    public int[] getArray() {
        return array;
    }

    @ano
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        StringBuilder str = new StringBuilder("[ " + array[0]);
        for(int i = 1; i < count; i++) {
            str.append(", ");
            str.append(array[i]);
        }
        str.append(']');
        return str.toString();
    }
}
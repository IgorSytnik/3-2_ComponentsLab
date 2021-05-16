package com.company.models;

public interface StackInt {
    void push(int element);
    int pop();
    int size();
    int capacity();
    int[] getArray();
    boolean isEmpty();
}

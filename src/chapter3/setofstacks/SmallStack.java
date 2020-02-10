package chapter3.setofstacks;

import java.util.EmptyStackException;

public class SmallStack {

    private static final int CAPACITY = 3;
    private int[] arr = new int[CAPACITY];
    private int size = 0;

    public void push(int data) {
        if (!full()) {
            arr[size] = data;
            size ++;
        } else {
            throw new StackOverflowError();
        }
    }

    public boolean empty(){ return size == 0;}

    public boolean full() {return size == CAPACITY;}

    public int size() {
        return size;
    }

    public int pop() {
        if (size == 0) throw new EmptyStackException();
        return arr[--size];
    }
}

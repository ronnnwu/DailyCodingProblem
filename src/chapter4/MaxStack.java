package chapter4;

import java.util.EmptyStackException;

public class MaxStack<T extends Comparable<T>> extends Stack<MaxStackElement<T>>{


    public T max() {
        if (arr.size()==0) throw new EmptyStackException();
        return (arr.get(arr.size() - 1)).runningMax;
    }

    private T max(T t1, T t2) {
        if (t1.compareTo(t2) < 0) return t2;
        return t1;
    }

    public void push(T data) {
        MaxStackElement<T> maxStackElement = arr.size()==0? new MaxStackElement(data, data): new MaxStackElement(data, this.max(data, this.max()));
        arr.add(maxStackElement);
    }
}

package chapter4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Queue<T> {


    public List<T> arr = new ArrayList<>();

    public void enqueue(T data) {
        arr.add(data);
    }

    public boolean empty() {return arr.size() == 0;}

    public T dequeue() {
        if (arr.size() == 0) throw new EmptyStackException();
        return arr.remove(0);
    }
}

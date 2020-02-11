package chapter3;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue<T> {

    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    public void enqueue(T data){
        s1.push(data);
    }

    public T dequeue() {
        if (s1.empty()) throw new EmptyStackException();
        while(!s1.empty()) s2.push(s1.pop());
        T data = s2.pop();
        while(!s2.empty()) s1.push(s2.pop());
        return data;
    }

    public boolean empty() {
        return s1.empty();

    }

}

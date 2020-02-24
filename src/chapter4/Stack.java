package chapter4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<T> {
    public List<T> arr = new ArrayList<>();

    public T pop() {
        if (arr.size()==0) throw new EmptyStackException();
        return arr.remove(arr.size() - 1);
    }

    public T peek(){
        if (arr.size()==0) throw new EmptyStackException();
        return arr.get(arr.size() - 1);
    }

    public void push(T data) {
         arr.add(data);
    }

    public boolean empty() {
        return arr.size() == 0;
    }
}

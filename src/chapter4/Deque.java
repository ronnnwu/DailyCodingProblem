package chapter4;

import java.util.EmptyStackException;

public class Deque<T> extends Queue<T> {


    public T popleft() {
        return this.dequeue();
    }

    public T pop() {
        if (arr.size() == 0) throw new EmptyStackException();
        return arr.remove(arr.size()-1);
    }


    public T peek() {
        if (arr.size() == 0) throw new EmptyStackException();
        return arr.get(arr.size()-1);
    }

    public T peekLeft() {
        if (arr.size() == 0) throw new EmptyStackException();
        return arr.get(0);
    }
}

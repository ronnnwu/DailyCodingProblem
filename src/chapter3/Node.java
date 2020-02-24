package chapter3;

public class Node<T> {
    T data;
    Node next;

    public Node() {
    }

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}

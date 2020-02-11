package chapter2;

import java.util.List;
import java.util.Stack;

public class LinkedList<T> {

    private Node<T> root;

    public LinkedList() {this.root = null;}

    public LinkedList(Node<T> node){
        this.root = node;
    }

    public LinkedList(List<T> data){
        Stack<T> stack = new Stack<>();

        for (T d: data){
            stack.push(d);
        }

        Node temp = stack.empty()? null: new Node(stack.pop());

        while(!stack.empty()) {
            Node node = new Node(stack.pop(), temp);
            temp = node;
        }

        this.root = temp;
    }

    public void printData() {
        Node temp = root;
        while(temp!= null){
            System.out.print(temp.getData());
            if (temp.getNext()!= null) {
                System.out.print("->");
            }
            temp = temp.getNext();
        }
        System.out.println();
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> node){ this.root =node;}

    public Node<T> getTail() {
        Node temp = root;
        while(temp!= null && temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp;
    }

    public void insertAtEnd(T data) {
        if (root==null) {
            root = new Node(data);
            return;
        }
        Node tmp = getTail();
        tmp.setNext(new Node(data));
    }
}


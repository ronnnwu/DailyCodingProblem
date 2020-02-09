package chapter2;

import java.util.List;
import java.util.Stack;

public class LinkedList<T> {

    private Node root = null;

    public LinkedList(Node node){
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

    public Node getRoot() {
        return root;
    }

    public Node getTail() {
        Node temp = root;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp;
    }

}


package chapter3;

import java.util.List;

public class LinkedList<T> {
    Node<T> root;

    public LinkedList(){}

    public LinkedList(List<T> list){
        if (list.size() == 0) return;
        Node superHead = new Node();
        Node tmp = superHead;
        for (T d: list) {
            tmp.next = new Node(d);
            tmp = tmp.next;
        }
        root = superHead.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node head = root;
        while (head != null) {
            sb.append(head.data);
            if (head.next != null) sb.append("->");
            head = head.next;
        }
        return sb.toString();
    }
}

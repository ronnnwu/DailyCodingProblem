package chapter2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Chapter2 {
    public LinkedList Ex1(LinkedList linkedList) {
        Node temp1 = linkedList.getRoot();
        while(temp1!= null) {
            Node temp2 = temp1;
            while(temp2.getNext()!=null){
                if (temp1.getData().equals(temp2.getNext().getData())) {
                    temp2.setNext(temp2.getNext().getNext());
                }
                temp2 = temp2.getNext();
            }
            temp1 = temp1.getNext();
        }
        return linkedList;
    }

    public LinkedList Ex2(LinkedList ll, int k) {
        Stack<Node> stack = new Stack<>();
        Node temp = ll.getRoot();
        while(temp!=null){
            stack.push(temp);
            temp = temp.getNext();
        }
        Node res = null;
        while(k-->0){
            res = stack.pop();
        }
        return new LinkedList(res);
    }

    public LinkedList Ex3(LinkedList ll, Node node) {
        if (node!=null && node.getNext()!= null) {
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        }
        return ll;
    }

    public LinkedList Ex4(LinkedList<Integer> ll, int partition) {
        Node head = ll.getRoot();
        Node tail = ll.getTail();
        Node tail2 = tail;
        while(head != tail) {
            if (((Integer)head.getData()) >= partition) {
                tail2.setNext(new Node(head.getData()));
                tail2 = tail2.getNext();
                head.setData(head.getNext().getData());
                head.setNext(head.getNext().getNext());
            }
            else head = head.getNext();
        }
        return ll;
    }

    public LinkedList Ex5(LinkedList l1, LinkedList l2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Node root = null;
        Node temp = l1.getRoot();
        while (temp!=null) {
            s1.push((Integer) temp.getData());
            temp = temp.getNext();
        }
        temp = l2.getRoot();
        while(temp!=null)  {
            s2.push((Integer)temp.getData());
            temp = temp.getNext();
        }
        int carry = 0;
        while (!s1.empty() || ! s2.empty()) {
            int v1 = s1.empty()? 0 : s1.pop();
            int v2 = s2.empty()? 0 : s2.pop();
            if (root == null) root = new Node((v1+v2+carry)%10);
            else root = new Node((v1+v2+carry)%10, root);
            carry = (v1+v2) / 10;
        }
        return new LinkedList(root);
    }

    public boolean Ex6(LinkedList ll) {
         Stack stack = new Stack<>();
         Node temp = ll.getRoot();
         int size = 0;
         while(temp!= null) {
             size ++;
             stack.push(temp.getData());
             temp = temp.getNext();
         }
         temp = ll.getRoot();
         for (int i = 0; i< size /2; i++) {
             if (!temp.getData().equals(stack.pop())) return false;
             temp = temp.getNext();
         }
         return true;
    }

    public boolean Ex7(LinkedList l1, LinkedList l2){
        Set<Node> set = new HashSet<>();
        Node tmp = l1.getRoot();
        while(tmp!=null){
            set.add(tmp);
            tmp = tmp.getNext();
        }
        tmp = l2.getRoot();
        while(tmp!= null){
            if (set.contains(tmp)) return true;
            tmp = tmp.getNext();
        }
        return false;
    }

    public Node Ex8(LinkedList ll){
        Set<Node> set = new HashSet<>();
        Node tmp = ll.getRoot();
        while(!set.contains(tmp)) {
            set.add(tmp);
            tmp = tmp.getNext();
        }
        return tmp;
    }
}

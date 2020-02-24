package chapter3;


public class Chapter3 {

    public LinkedList ex1(LinkedList ll){
        if (ll.root == null || ll.root.next==null) return ll;
        Node h1 = ll.root;
        Node head = h1;
        while (h1.next != null) {
            Node headTemp = h1.next;
            h1.next = headTemp.next;
            headTemp.next = head;
            head = headTemp;
        }
        return new LinkedList(head);
    }

    public LinkedList<Integer> ex2(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Node<Integer> h1 = l1.root;
        Node<Integer> h2 = l2.root;
        Node<Integer> root = new Node(null);
        Node<Integer> tmp = root;
        int carry = 0;
        while (h1 != null || h2 !=null || carry != 0) {
            int n1 = h1!=null? h1.data: 0;
            int n2 = h2!=null? h2.data: 0;
            int result = (n1+n2+carry) %10;
            carry = (n1+n2+carry) / 10;
            tmp.next = new Node(result);
            tmp = tmp.next;
            h1 = h1==null? null: h1.next;
            h2 = h2==null? null: h2.next;
        }
        return new LinkedList(root.next);
    }

    public LinkedList<Integer> ex3(LinkedList<Integer> ll) {
        if (ll.root == null || ll.root.next==null) return ll;
        Node<Integer> tmp = ll.root;
        boolean lowToHigh = true;
        while(tmp.next!=null) {
            if ((lowToHigh && (Integer)tmp.next.data < tmp.data) ||
               (!lowToHigh && (Integer)tmp.next.data > tmp.data) ){
                Integer t = tmp.data;
                tmp.data = (Integer) tmp.next.data;
                tmp.next.data = t;
            }
            lowToHigh = !lowToHigh;
            tmp = tmp.next;
        }
        return new LinkedList(ll.root);
    }

    public Node ex4(LinkedList l1, LinkedList l2) {
        int s1 = l1.getLength();
        int s2 = l2.getLength();

        Node h1 = s1>=s2? l1.root: l2.root;
        Node h2 = s1>=s2? l2.root: l1.root;

        for(int i=0; i<Math.abs(s1-s2); i++) {
            h1 = h1.next;
        }

        while(!h1.data.equals(h2.data)){
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }
}

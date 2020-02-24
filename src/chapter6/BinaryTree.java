package chapter6;

import chapter4.Queue;


public class BinaryTree<T> {
    public Node<T> root;


    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    private int _height(Node root){
        if (root==null) return 0;
        return 1 + Math.max(_height(root.left), _height(root.right));
    }

    public int height() {
        return _height(root);
    }

    private boolean isUnival(Node root, int[] result) {
        if (root == null) return true;
        if (root.left == null && root.right==null)  {
            result[0] ++;
            return true;
        }
        if (isUnival(root.left, result) && isUnival(root.right, result)){
            if ((root.left == null && root.right.data.equals(root.data)) ||
                    (root.right == null && root.left.data.equals(root.data)) ||
                    ( root.left.data.equals(root.data) && root.right.data.equals(root.data))){
                result[0] ++;
                return true;
            }
        }
        return false;
    }

    public int countSubunival() {
        int[] result = new int[]{0};
        isUnival(root, result);
        return result[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new Queue();
        q.enqueue(root);
        int h = height();
        while(h-->0) {
            Queue<Node> q1 = new Queue();
            while (!q.empty()) {
                Node node = q.dequeue();
                if (node == null) {
                    sb.append("[] ");
                    q1.enqueue(null);
                    q1.enqueue(null);
                } else {
                    sb.append(node.data + " ");
                    q1.enqueue(node.left);
                    q1.enqueue(node.right);
                }
            }
            q = q1;
            sb.append("\n");
        }
        return new String(sb);
    }

}

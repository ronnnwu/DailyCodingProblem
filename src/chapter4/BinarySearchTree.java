package chapter4;

import chapter3.MyQueue;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryNode<T> root= null;

    private int height_helper(BinaryNode root) {
        if (root == null) return 0;
        return Math.max(height_helper(root.getNodes()[0]), height_helper(root.getNodes()[1])) + 1;
    }

    public int height() {
        return height_helper(root);
    }

    public BinaryNode<T> getRoot() {return root;}

    private void insert_helper(BinaryNode root, T data) {
        if (root.getData().compareTo(data) < 0) {
            if (root.getNodes()[1] == null) {
                root.getNodes()[1] = new BinaryNode(data);
            } else {
                insert_helper(root.getNodes()[1], data);
            }
        } else {
            if (root.getNodes()[0] == null) {
                root.getNodes()[0] = new BinaryNode(data);
            } else {
                insert_helper(root.getNodes()[0], data);
            }
        }
    }

    public void insert(T data) {
        if(root == null) root = new BinaryNode(data);
        else insert_helper(root, data);
    }

    public void printTree() {
        MyQueue<BinaryNode> queue = new MyQueue<>();
        queue.enqueue(root);
        int currentCount = 0;
        int nextLine = 1;
        int height = height();
        while(height>0){
            BinaryNode node = queue.dequeue();
            if (node == null) {
                queue.enqueue(null);
                queue.enqueue(null);
                System.out.print("[]  ");
            } else {
                queue.enqueue(node.getNodes()[0]);
                queue.enqueue(node.getNodes()[1]);
                System.out.print(node.getData().toString() + "  ");
            }
            currentCount++;
            if (currentCount == nextLine) {
                System.out.println();
                height --;
                currentCount = 0;
                nextLine *= 2;
            }
        }
    }

    private Integer heightDfs(BinaryNode root) {
        if (root == null) return 0;
        Integer leftHeight = heightDfs(root.getNodes()[0]);
        Integer rightHeight = heightDfs(root.getNodes()[1]);
        if (leftHeight == null || rightHeight == null || Math.abs(leftHeight-rightHeight) > 1) return null;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalance() {
        return heightDfs(root) != null;
    }


}

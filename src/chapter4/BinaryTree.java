package chapter4;

import chapter3.MyQueue;

import java.util.Random; 

public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    private int height_helper(BinaryNode root) {
        if (root == null) return 0;
        return Math.max(height_helper(root.getLeft()), height_helper(root.getRight())) + 1;
    }

    public int height() {
        return height_helper(root);
    }

    public BinaryNode<T> getRoot() {return root;}
    public void setRoot(BinaryNode<T> root) { this.root = root;}


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
                queue.enqueue(node.getLeft());
                queue.enqueue(node.getRight());
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
        Integer leftHeight = heightDfs(root.getLeft());
        Integer rightHeight = heightDfs(root.getRight());
        if (leftHeight == null || rightHeight == null || Math.abs(leftHeight-rightHeight) > 1) return null;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalance() {
        return heightDfs(root) != null;
    }


    public boolean isSubTree(BinaryTree<T> subtree) {
        if (root == subtree.getRoot()) return true;
        MyQueue<BinaryNode> queue = new MyQueue<>();
        queue.enqueue(root);
        while(!queue.empty()) {
            BinaryNode<T> node = queue.dequeue();
            if (node == subtree.getRoot()) return true;
            if (node.getLeft() != null) queue.enqueue(node.getLeft());
            if (node.getRight() != null) queue.enqueue(node.getRight());
        }
        return false;
    }

    private BinaryNode<T> getRandomNode_helper(BinaryNode<T> node) {
        Random random = new Random();
        int rInt = random.nextInt(node.getSize());
        if (node.getLeft()!=null && rInt <node.getLeft().getSize()) return getRandomNode_helper(node.getLeft());
        if (node.getLeft()!=null && rInt == node.getLeft().getSize()) return node;
        if (node.getLeft()==null && rInt == 0) return node;
        return getRandomNode_helper(node.getRight());
    }

    public BinaryNode<T> getRandomNode() {
        return getRandomNode_helper(root);
    }
}

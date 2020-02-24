package chapter7;

import chapter6.BinaryTree;
import chapter6.Node;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {



    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(Node root) {
        super(root);
    }

    public BinarySearchTree(List<T> list) {
        for (T t: list) {
            insert(t);
        }
    }

    private void _insert(Node<T> root, T data) {
        if (root.data.compareTo(data)>0) {
            if (root.left == null) {
                root.left = new Node(data);
            }
            else {
                _insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);
            }
            else {
                _insert(root.right, data);
            }
        }
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node(data);
        } else {
            _insert(root, data);
        }
    }

}

package chapter4;

public class BinarySearchTree<T extends Comparable<T>>  extends BinaryTree<T>{
    private void insert_helper(BinaryNode<T> root, T data) {
        if (root.getData().compareTo(data) < 0) {
            if (root.getRight() == null) {
                root.setRight( new BinaryNode(data) );
            } else {
                insert_helper(root.getRight(), data);
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft( new BinaryNode(data) );
            } else {
                insert_helper(root.getLeft(), data);
            }
        }
        root.incrementSize();
    }

    public void insert(T data) {
        if(getRoot() == null) {
            setRoot(new BinaryNode(data));
        }
        else insert_helper(getRoot(), data);
    }
}

package chapter4;

public class BinaryBalanceTree<T> extends BinaryTree<T> {

    private void insert_helper(BinaryNode<T> root, T data) {
        if (root.getLeft() == null) {
            root.setLeft(new BinaryNode(data));
        } else if (root.getRight() == null) {
            root.setRight(new BinaryNode(data));
        } else if (root.getLeft().getSize() <= root.getRight().getSize()) {
            insert_helper(root.getLeft(), data);
        } else {
            insert_helper(root.getRight(), data);
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

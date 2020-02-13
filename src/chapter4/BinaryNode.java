package chapter4;


public class BinaryNode<T>  {
    private T data;
    private BinaryNode<T> left ;
    private BinaryNode<T> right ;
    private int size;

    public BinaryNode(T data) {
        this.data = data;
        this.size = 1;
    }

    public T getData() {return data;}

    public BinaryNode getLeft() {return left;}

    public BinaryNode getRight() {return right;}

    public void setLeft(BinaryNode node) {
        this.left = node;
    }

    public void setRight(BinaryNode node) {
        this.right = node;
    }

    public void incrementSize() {
        size++;
    }

    public int getSize() {return size;}
}

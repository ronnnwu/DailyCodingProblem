package chapter4;

import chapter2.Node;

public class BinaryNode<T extends Comparable<T>>  {
    private T data;
    private BinaryNode[] nodes ;

    public BinaryNode(T data) {
        this.data = data;
        this.nodes =  new BinaryNode[2];
    }

    public BinaryNode(T data, BinaryNode[] nodes) {
        this.data = data;
        this.nodes = nodes;
    }

    public T getData() {return data;}
    public BinaryNode[] getNodes() {return nodes;}

    public void setLeftNodes(BinaryNode node) {
        nodes[0] = node;
    }

    public void setRightNodes(BinaryNode node) {
        nodes[1] = node;
    }
}

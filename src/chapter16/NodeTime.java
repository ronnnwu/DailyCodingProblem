package chapter16;

import chapter2.Pair;

public class NodeTime<V, T extends Comparable<T>> extends Pair<V, T> implements Comparable<NodeTime>{
    public NodeTime(V node, T time) {
        super(node, time);
    }

    @Override
    public int compareTo(NodeTime o) {
        return this.y.compareTo((T) o.y);
    }
}

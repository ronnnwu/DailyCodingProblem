package chapter9;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private List<T> list;

    public MinHeap() {
        this.list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public List<T> getList() {return list;}

    @Override
    public String toString(){
        return list.toString();
    }

    // bubble-up
    public void insert(T item) {
        list.add(item);
        int i = list.size()-1;
        Integer parent = parent(i);
        while (parent != null && list.get(parent).compareTo(list.get(i))>0) {
            swap(parent, i);
            i = parent;
            parent = parent(i);
        }
    }

    public T getMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("MinHeap is EMPTY");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T extractMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("MinHeap is EMPTY");
        } else if (list.size() == 1) {
            T min = list.remove(0);
            return min;
        }
        T min = list.get(0);
        T lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);
        minHeapify(0);
        return min;
    }

    // bubble-down
    private void minHeapify(int parent) {
        Integer left = left(parent);
        Integer right = right(parent);
        int smallest;

        if (left != null && list.get(left).compareTo(list.get(parent))<0) {
            smallest = left;
        } else {
            smallest = parent;
        }
        if (right != null && list.get(right).compareTo(list.get(smallest))<0) {
            smallest = right;
        }
        if (smallest != parent) {
            swap(parent, smallest);
            minHeapify(smallest);
        }
    }


    private Integer right(int i) {
        int right = 2 * i + 2;
        return right>=list.size()? null: right;
    }

    private Integer left(int i) {
        int left = 2 * i + 1;
        return left>=list.size()? null: left;
    }

    private Integer parent(int i) {
        return i==0? null: (i - 1) / 2;
    }

    private void swap(int i, int j) {

        T temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
    }


}

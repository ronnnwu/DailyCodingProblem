package chapter7;

import chapter6.Node;

import java.util.ArrayList;
import java.util.List;

public class Chapter7 {

    private List<Integer> getBound(Node<Integer> root, int k, Integer floor, Integer ceil) {
        if (root == null){
            return List.of(floor, ceil);
        }
        if (root.data.equals(k)) return List.of(k, k);
        if (root.data > k) return getBound(root.left, k, floor, root.data);
        return getBound(root.right, k,   root.data, ceil);

    }

    public List<Integer> ex1(BinarySearchTree<Integer> bt, int k) {
        return getBound(bt.root, k, null, null);
    }

    private void balanceTree(BinarySearchTree bt, int[] arr, int h, int t){
        if (t<h) return;
        int mid = h + (t-h)/2;
        bt.insert(arr[mid]);
        balanceTree(bt, arr, h, mid-1);
        balanceTree(bt, arr, mid+1, t);
    }

    public BinarySearchTree<Integer> ex2(int[] arr) {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        balanceTree(bt, arr, 0, arr.length-1);
        return bt;
    }

    private List<BinarySearchTree<Integer>> makeTrees(int low, int high) {
        List<BinarySearchTree<Integer>> bts = new ArrayList<>();
        if (low > high) {
            bts.add(null);
            return bts;
        }
        for (int i = low; i<= high; i++) {
            List<BinarySearchTree<Integer>> left = makeTrees(low, i - 1);
            List<BinarySearchTree<Integer>> right = makeTrees(i + 1, high);

            for(BinarySearchTree l: left) {
                for(BinarySearchTree r: right) {
                    Node ln = l == null? null: l.root;
                    Node rn = r == null? null: r.root;
                    bts.add(new BinarySearchTree(new Node(i, ln, rn)));
                }
            }
        }
        return bts;
    }

    public List<BinarySearchTree<Integer>> ex3(int n) {
        return makeTrees(1, n);
    }
}

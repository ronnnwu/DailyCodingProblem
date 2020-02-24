package chapter6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Chapter6 {
    public void ex1(){

        BinaryTree<Character> bt = new BinaryTree<>();
        bt.root = new Node('a');
        bt.root.left = new Node('c');
        bt.root.right = new Node('b');
        bt.root.right.left = new Node('b');
        bt.root.right.right = new Node('b');
        bt.root.right.right.right = new Node('b');

        System.out.println(bt);

        System.out.println(bt.countSubunival());

    }

    private Node constructBt(List<Character> preorder, List<Character> inorder) {
        if (preorder.size() <= 0) return null;
        Node root = new Node(preorder.get(0));
        int idx = inorder.indexOf(preorder.get(0));
        root.left = constructBt(preorder.subList(1, idx+1), inorder.subList(0, idx));
        root.right = constructBt(preorder.subList(idx+1, preorder.size()), inorder.subList(idx+1, inorder.size()));
        return root;
    }

    public BinaryTree ex2(List<Character> preorder, List<Character> inorder) {
        return new BinaryTree(constructBt(preorder, inorder));
    }


    private int valuation(Node<String> root) {
        if (root.left ==null && root.right ==null){
            return Integer.parseInt(root.data);
        }
        int left = valuation(root.left);
        int right = valuation(root.right);
        if (root.data.equals("+")) return left + right;
        if (root.data.equals("-")) return left - right;
        if (root.data.equals("*")) return left * right;
         return left / right;
    }

    public int ex3(BinaryTree bt) {
        return valuation(bt.root);
    }

    private void levelSum(Node<Integer> root, Map<Integer, Integer> map, int level){
        if (root == null) return;
        if (map.containsKey(level)) {
            map.put(level, map.get(level) + root.data);
        } else {
            map.put(level, root.data);
        }
        levelSum(root.left, map, level+1);
        levelSum(root.right, map, level+1);
    }

    public int ex4(BinaryTree<Integer> bt) {

        Map<Integer, Integer> map = new HashMap<>();
        levelSum(bt.root, map, 0);

        int result = 0;
        int totSmall = bt.root.data;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue()<totSmall) {
                result = entry.getKey();
                totSmall = entry.getValue();
            }
        }
        return result;

    }
}

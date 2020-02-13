package chapter4;

import chapter2.LinkedList;

import java.util.*;
import java.util.stream.Collectors;

public class Chapter4 {
    public void Ex1() {

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        adjacencyList.put(1, List.of(2,3,4,5));
        adjacencyList.put(2, List.of(1,4));
        adjacencyList.put(3, List.of(4));

        Graph graph = new Graph(adjacencyList);

        System.out.println(graph.isConnected(1,2));
        System.out.println(graph.isConnected(1,5));

    }

    private void insertSortedListToTree_helper(BinarySearchTree tree , int[] list, int h, int t) {
        if (t>=h) {
            int m = h+(t-h)/2;
            tree.insert(list[m]);
            insertSortedListToTree_helper(tree, list, h, m-1);
            insertSortedListToTree_helper(tree, list, m+1, t);
        }
    }

    private BinarySearchTree insertSortedListToTree(int[] list) {
        BinarySearchTree tree = new BinarySearchTree();
        insertSortedListToTree_helper(tree, list, 0, list.length-1);
        return tree;
    }


    public void Ex2() {

        BinaryTree tree = insertSortedListToTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        tree.printTree();
    }

    private void createDLinkedLists_helper(BinaryNode root, List<LinkedList> lls, int level) {
        if(root == null) return;
        if (lls.size() < level + 1) {
            lls.add(new LinkedList());
        }
        lls.get(level).insertAtEnd(root.getData());
        createDLinkedLists_helper(root.getLeft(), lls, level+1);
        createDLinkedLists_helper(root.getRight(), lls, level+1);

    }

    private List<LinkedList> createDLinkedLists(BinaryTree tree) {
        List<LinkedList> lls = new ArrayList<>();
        createDLinkedLists_helper(tree.getRoot(), lls, 0);
        return lls;
    }

    public void Ex3() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i : List.of(10,4,6,1,7,9, 2))
            tree.insert(i);

        tree.printTree();

        List<LinkedList> dLinkedLists = createDLinkedLists(tree);
        for (LinkedList ll: dLinkedLists) {
            ll.printData();
        }

    }


    public void Ex4() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i : List.of(10,4,6,1,7,9, 2))
            tree.insert(i);
        tree.printTree();
        System.out.println(tree.isBalance());

        tree = insertSortedListToTree(new int[]{1, 2, 3, 4, 5, 6});
        tree.printTree();
        System.out.println(tree.isBalance());
    }



    private boolean validateBST_help(BinaryNode<Integer> root, Integer leftBound, Integer rightBound){
        if (root == null) return true;
        if (root.getData() < leftBound || root.getData() > rightBound) {
            return false;
        }
        return validateBST_help(root.getLeft(), leftBound, Math.min(rightBound, root.getData())) &&
                validateBST_help(root.getRight(), Math.max(leftBound, root.getData()), rightBound);
    }

    public boolean validateBST(BinaryTree tree) {
        return validateBST_help(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void Ex5() {

        BinarySearchTree tree = new BinarySearchTree();
        for (int i : List.of(5,4,6,1,7,9,2))
            tree.insert(i);
        tree.getRoot().getLeft().setRight(new BinaryNode(10)); // make it non-binary search
        tree.printTree();
        System.out.println(validateBST(tree));
    }

    private void inorder(BinaryNode<Integer> node, int lookfor, Integer[] result, boolean[] found) {
        if (node == null) return;
        inorder(node.getLeft(), lookfor, result, found);
        if (found[0] && result[0] == null) {
            result[0] = node.getData();
            return;
        }
        if (node.getData().equals(lookfor)) found[0] = true;
        inorder(node.getRight(), lookfor, result, found);
    }

    public Integer nextNode(BinaryTree<Integer> tree, int lookfor) {
        Integer[] result = new Integer[1];
        boolean[] found = new boolean[1];
        inorder(tree.getRoot(), lookfor, result, found);
        return result[0];
    }

    public void Ex6() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i : List.of(5,4,6,1,7,9,2))
            tree.insert(i);
        System.out.println(nextNode(tree, 2));
    }



    public void Ex7() {

        Graph graph = new Graph(List.of('a', 'b', 'c', 'd', 'e', 'f'),
                                List.of(new Pair('d', 'a'), new Pair('b', 'f'),
                                        new Pair('d', 'b'), new Pair('a', 'f'),
                                        new Pair('c', 'd')));


        System.out.println(graph.topologicalSort());
    }




    private <T extends Comparable<T>> T findCommonAncestor(BinaryNode<T> root, T x, T y) {
        if (root ==null) return null;
        if (root.getData().equals(x)) return x;
        if (root.getData().equals(y)) return y;
        T leftfound = (T)findCommonAncestor(root.getLeft(), x, y);
        T rightfound = (T)findCommonAncestor(root.getRight(), x, y);
        if (leftfound != null && leftfound.equals(rightfound)) return rightfound;
        if (leftfound != null && rightfound != null && (leftfound.equals(x) && rightfound.equals(y) || leftfound.equals(y) && rightfound.equals(x)))
            return root.getData();
        return leftfound == null? rightfound : leftfound;
    }


    public void Ex8() {
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        for (int i : List.of(5,4,6,1,7,9,2))
            tree.insert(i);
        tree.getRoot().getLeft().setRight(new BinaryNode(10)); // make it non-binary search
        tree.printTree();


        System.out.println(findCommonAncestor(tree.getRoot(), 1,2));
    }

    private  <T> List<List<T>> permutation(Set<T> s){

        List<List<T>> result = new ArrayList<>();
        for (T t: s){
            Set<T> s1 = new HashSet(s);
            s1.remove(t);
            List<List<T>> l;
            if (s1.size() > 0) {
                 l = permutation(s1);
                 for (List<T> ll: l){
                     ll.add(t);
                 }
            } else {
                l = List.of(new ArrayList<>(List.of(t)));
            }
            result.addAll(l);
        }
        return result;
    }

    private <T extends Comparable<T>> List<List<T>> bstSequence(BinaryTree<T> tree) {
        int level = 1;
        Map<Integer, List<BinaryNode<T>>> map = new HashMap<>();
        map.put(1, List.of(tree.getRoot()));
        while (map.containsKey(level)) {
            List<BinaryNode<T>> levelNode = new ArrayList<>();
            for (BinaryNode node: map.get(level)) {
                if (node.getLeft() != null)
                    levelNode.add(node.getLeft());
                if (node.getRight() != null)
                    levelNode.add(node.getRight());
            }
            level ++;
            if (levelNode.size() > 0) {
                map.put(level, levelNode);
            }
        }
        List<List<T>> result = new ArrayList<>();
        for (int i = 1; i < level; i++) {
            List<List<T>> lists = permutation(map.get(i).stream().map(x -> x.getData()).collect(Collectors.toSet()));
            if (result.size() == 0) {
                result = lists;
            } else {
                List<List<T>> result1 = new ArrayList<>();
                for (List<T> list : lists){
                    for (List<T> r: result){
                        ArrayList<T> ts = new ArrayList<>(r);
                        ts.addAll(list);
                        result1.add(ts);
                    }
                }
                result = result1;
            }
        }
        return result;
    }


    public void Ex9() {
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        for (int i : List.of(2,1,3))
            tree.insert(i);
        tree.printTree();
        System.out.println(bstSequence(tree));

    }

    public void Ex10() {
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        for (int i : List.of(4, 5, 10, 2, 1, 3, 0))
            tree.insert(i);
        tree.printTree();

        BinaryTree<Integer> subtree = new BinaryTree<>(tree.getRoot().getLeft().getLeft());
        subtree.printTree();

        System.out.println(tree.isSubTree(subtree));
    }

    public void Ex11() {
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        for (int i : List.of(4, 5, 10, 2, 1, 3, 0))
            tree.insert(i);
        tree.printTree();

        int N = 10;
        for(int i =0; i<N; i++) System.out.println(tree.getRandomNode().getData());

    }

    private void sumPath(BinaryNode<Integer> root, Map<Integer, Integer> runningTotal, int currentTotal, int lookfor, int[] result) {
        if (root == null) return;
        int total = currentTotal+root.getData();
        if (total ==  lookfor) {
            result[0] ++;
        }
        Map<Integer, Integer> runingCoppy = new HashMap(runningTotal);
        if (runingCoppy.containsKey(total)) {
            runingCoppy.put(total, runingCoppy.get(total) + 1);
        } else {
            runingCoppy.put(total, 1);
        }

        if (runingCoppy.containsKey(total-lookfor)) {
            result[0] += runingCoppy.get(total-lookfor);
        }
        sumPath(root.getLeft(), runingCoppy, total, lookfor, result);
        sumPath(root.getRight(), runingCoppy, total, lookfor, result);
    }


    public void Ex12() {
        BinaryBalanceTree<Integer> tree = new BinaryBalanceTree();
        for (int i : List.of(10, 5, -3, 3, 2, 0, 11, 3, -2, 1))
            tree.insert(i);
        tree.printTree();
        int[] result = new int[1];
        int lookfor = 8;
        sumPath(tree.getRoot(), new HashMap<>(), 0, lookfor, result);
        System.out.println(result[0]);

    }
}

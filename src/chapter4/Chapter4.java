package chapter4;

import chapter2.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        BinarySearchTree tree = insertSortedListToTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        tree.printTree();
    }

    private void createDLinkedLists_helper(BinaryNode root, List<LinkedList> lls, int level) {
        if(root == null) return;
        if (lls.size() < level + 1) {
            lls.add(new LinkedList());
        }
        lls.get(level).insertAtEnd(root.getData());
        createDLinkedLists_helper(root.getNodes()[0], lls, level+1);
        createDLinkedLists_helper(root.getNodes()[1], lls, level+1);

    }

    private List<LinkedList> createDLinkedLists(BinarySearchTree tree) {
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
        return validateBST_help(root.getNodes()[0], leftBound, Math.min(rightBound, root.getData())) &&
                validateBST_help(root.getNodes()[1], Math.max(leftBound, root.getData()), rightBound);
    }

    public boolean validateBST(BinarySearchTree tree) {
        return validateBST_help(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void Ex5() {

        BinarySearchTree tree = new BinarySearchTree();
        for (int i : List.of(5,4,6,1,7,9,2))
            tree.insert(i);
        tree.getRoot().getNodes()[0].setRightNodes(new BinaryNode(10)); // make it non-binary search
        tree.printTree();
        System.out.println(validateBST(tree));
    }

    private void inorder(BinaryNode<Integer> node, int lookfor, Integer[] result, boolean[] found) {
        if (node == null) return;
        inorder(node.getNodes()[0], lookfor, result, found);
        if (found[0] && result[0] == null) {
            result[0] = node.getData();
            return;
        }
        if (node.getData().equals(lookfor)) found[0] = true;
        inorder(node.getNodes()[1], lookfor, result, found);
    }

    public Integer nextNode(BinarySearchTree<Integer> tree, int lookfor) {
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

}

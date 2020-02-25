package chapter8;

import java.util.Map;

public class PrefixMapSum {

    public TrieSumNode root = new TrieSumNode();

    public void insert(String word, int val) {

        Map<Character, TrieSumNode> children = root.children;
        for (int i =0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieSumNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
                t.total += val;
            } else {
                t = new TrieSumNode(c, val);
                children.put(c, t);
            }
            children = t.children;

            if (i==word.length()-1) {
                t.isLeaf = true;
            }
        }
    }

    public Integer sum(String prefix) {
        Map<Character, TrieSumNode> children = root.children;
        TrieSumNode t= null;
        for (char c : prefix.toCharArray()) {
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                return null;
            }
            children = t.children;
        }
        return t.total;
    }


}

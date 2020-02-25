package chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        Map<Character, TrieNode> tmp = root.children;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if (tmp.containsKey(c)) {
                t = tmp.get(c);
            } else {
                t = new TrieNode(c);
                tmp.put(c, t);
            }
            tmp = t.children;

            if (i == word.length()-1) {
                t.isLeaf = true;
            }
        }

    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if(t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode t = searchNode(prefix);
        if(t != null)
            return true;
        else
            return false;
    }

    private List<String> allWordsInNode(TrieNode t){
        List<String> list = new ArrayList<>();
        if (t.isLeaf) return List.of(Character.toString(t.c));
        for (TrieNode tr: t.children.values()){
            List<String> strings = allWordsInNode(tr);
            for (String s: strings) {
                list.add(t.c+s);
            }
        }
        return list;
    }

    public List<String> autocomplete(String prefix) {
        TrieNode t = searchNode(prefix);
        if (t == null) return null;
        List<String> strings = allWordsInNode(t);
        List<String> list = new ArrayList<>();
        for (String s: strings) {
            list.add(prefix.substring(0, prefix.length()-1)+s);
        }
        return list;
    }

    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }
}
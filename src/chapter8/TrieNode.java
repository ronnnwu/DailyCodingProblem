package chapter8;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
   public char c;
   public Map<Character, TrieNode> children = new HashMap<>();
   public boolean isLeaf = false;

   public TrieNode( ){
   }

   public TrieNode(char c){
       this.c = c;
   }
}

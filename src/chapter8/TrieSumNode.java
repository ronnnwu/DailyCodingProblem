package chapter8;

import java.util.HashMap;
import java.util.Map;

public class TrieSumNode  {
     public char c;
     public int total = 0;
     public boolean isLeaf = false;

     public Map<Character, TrieSumNode> children = new HashMap<>();

     public TrieSumNode() {}

     public TrieSumNode(char c, int val) {
         this.c = c;
         this.total = val;
     }
}

package chapter5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Chapter5 {

    public void ex1() {
        LRU<Character, Integer> lru = new LRU<>(2);

        lru.set('a', 1);
        lru.set('b', 2);
        lru.set('c', 3);
        System.out.println(lru.get('a'));
        System.out.println(lru.get('b'));
    }

    public int ex2(List<List<Integer>> bricks) {
        Map<Integer, Integer> width = new HashMap();
        for (List<Integer> row: bricks) {
            int tot = 0;
            for (Integer brick: row) {
                tot = tot + brick;
                if (width.containsKey(tot)) {
                    width.put(tot, width.get(tot) + 1);
                } else if (tot != 10) {
                    width.put(tot, 1);
                }
            }
        }
        int maxKey = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry: width.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxKey;
    }

    public void ex3() {
        SparseArray sp = new SparseArray();
        sp.init(new int[]{0,0,1,0,0,2,0,0,0,0});
        System.out.println(sp.get(2));
    }

}

package chapter5;

import java.util.HashMap;
import java.util.Map;

public class SparseArray {
    private Map<Integer, Integer> map = new HashMap<>();

    public void init(int[] arr) {
        for (int i=0; i< arr.length; i++) {
            if (arr[i] != 0) {
                map.put(i, arr[i]);
            }
        }
    }

    public void set(int i, int val) {
        map.put(i, val);
    }

    public int get(int i) {
        if (map.containsKey(i)){
            return map.get(i);
        }
        return 0;
    }
}

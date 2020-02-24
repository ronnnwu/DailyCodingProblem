package chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRU<T, V> {

    private List<T> arr = new ArrayList<>();
    private Map<T, V> map = new HashMap<>();
    private int capacity;

    public LRU(int n){
        this.capacity = n;
    }

    public void set(T key, V value) {
        if (map.size()==capacity){
            map.remove(arr.remove(0));
        }
        if (map.containsKey(key)) {
            arr.remove(arr.indexOf(key));
        }
        map.put(key, value);
        arr.add(key);
    }

    public V get(T key) {
        if (map.containsKey(key)) {
            arr.remove(arr.indexOf(key));
            arr.add(key);
            return map.get(key);
        }
        return null;
    }
}

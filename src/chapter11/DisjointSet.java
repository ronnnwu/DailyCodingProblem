package chapter11;

import java.util.*;

public class DisjointSet<T> {
    private Map<T, T> sets;
    private Map<T, Integer> sizes;
    private int count;

    public Map getSets() {return sets;}

    public DisjointSet(Set<T> elements) {
        sets = new HashMap<>();
        sizes = new HashMap<>();
        for (T t: elements) {
            sets.put(t, t);
            sizes.put(t, 1);
        }
        count = elements.size();
    }

    public void union(T t1, T t2) {
        T x = find(t1);
        T y = find(t2);
        if (!x.equals(y)) {
            if (sizes.get(x) < sizes.get(y)) {
                T tmp = y;
                y = x;
                x = tmp;
            }
            sets.put(y, x);
            sizes.put(x, sizes.get(x) + sizes.get(y));
            count -= 1;
        }
    }

    private T find(T t) {
        T group = sets.get(t);

        while(!group.equals(sets.get(group)))
            group = sets.get(group);

        sets.put(t, group);
        return group;
    }
}

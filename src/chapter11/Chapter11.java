package chapter11;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter11 {


    public class Subscribers {
        private BIT bit;
        private int[] arr;
        public Subscribers(int[] arr) {
            this.arr = arr;
            bit= new BIT(arr);
        }
        public void update(int hour, int value){
            bit.update(hour+1, value-arr[hour]);
            arr[hour]=value;
        }
        public int query(int start, int end){
            return bit.query(end+1)-bit.query(start);
        }

    }

    public void ex1() {
        Subscribers subscribers = new Subscribers(new int[] {4,8,1,9,3,5,5,3});
        System.out.println(subscribers.query(0,2));
        subscribers.update(0,-1);
        System.out.println(subscribers.query(0,2));
    }

    public void ex2() {
        Map<Integer, List<Integer>> friends = new HashMap<>();
        friends.put(0, List.of(1,2));
        friends.put(1, List.of(0,5));
        friends.put(2, List.of(0));
        friends.put(3, List.of(6));
        friends.put(4, List.of());
        friends.put(5, List.of(1));
        friends.put(6, List.of(3));

        DisjointSet friendGroup = new DisjointSet(friends.keySet());

        for(Map.Entry<Integer, List<Integer>> entry: friends.entrySet()) {
            for (Integer friend: entry.getValue()) {
                friendGroup.union(entry.getKey(), friend);
            }
        }
        System.out.println(friendGroup.getSets());
    }

    public void ex3() throws NoSuchAlgorithmException {
        BloomFilter bf = new BloomFilter(10);
        bf.add(10);
        System.out.println(bf.check(10));
    }

}

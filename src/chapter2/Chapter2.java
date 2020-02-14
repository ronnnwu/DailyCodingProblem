package chapter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter2 {
    public List<Integer> ex1(String w, String s){
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : w.toCharArray()){
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        for (int i = 0; i < w.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == 1) map.remove(c);
                else map.put(c, map.get(c) - 1);
            }
            else map.put(c, -1);
        }

        if (map.size() == 0) result.add(0);

        for (int i = w.length(); i<s.length(); i++) {
            char start = s.charAt(i-w.length());
            char end = s.charAt(i);

            if (map.containsKey(start)) {
                if (map.get(start) == -1) map.remove(start);
                else map.put(start, map.get(start) + 1);
            }
            else map.put(start, 1);

            if (map.containsKey(end)) {
                if (map.get(end) == 1) map.remove(end);
                else map.put(end, map.get(end) - 1);
            }
            else map.put(end, -1);

            if (map.size() == 0) {
                result.add(i-w.length()+1);
            }
        }

        return result  ;
    }
}

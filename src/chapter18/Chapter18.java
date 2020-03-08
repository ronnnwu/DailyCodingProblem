package chapter18;

import chapter16.Triple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter18 {
    public Map<Character, Integer> ex3(List<Triple<Character, Character, Double>> list, Character start, int steps){

        Map<Character, Map<Character, Double>> prob = new HashMap<>();

        for(Character a: List.of('a', 'b', 'c')) {
            prob.put(a, new HashMap<>());
        }
        for(Triple<Character, Character, Double> l: list) {
            prob.get(l.x).put(l.y, l.z);
        }

        Map<Character, Integer> result = new HashMap<>();
        result.put('a', 0);
        result.put('b', 0);
        result.put('c', 0);

        for (int i = 0; i<steps; i++) {
            result.put(start, result.get(start) + 1);
            double p = Math.random();

            for(Character a: List.of('a', 'b', 'c')) {
                p -= prob.get(start).get(a);
                if (p<=0) {
                    start = a;
                    break;
                }
            }
        }
        return result;
    }
}

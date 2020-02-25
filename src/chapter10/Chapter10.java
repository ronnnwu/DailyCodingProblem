package chapter10;

import chapter2.Pair;
import chapter4.Queue;

import java.util.*;

public class Chapter10 {
    public boolean ex1(UndirectGraph g){
        return g.isCyclic();
    }

    private <V> void NumNodes(DirectGraph<V> g, Map<V, Integer> count, V root, int[] result) {
        if (!g.adjacencyList.containsKey(root) || g.adjacencyList.get(root).size() == 0){
            count.put(root, 1);
        } else {
            int sum = 0;
            for (V v: g.adjacencyList.get(root)) {
                NumNodes(g, count, v, result);
                sum += count.get(v);
            }
            count.put(root, sum + 1);
            if (sum % 2 == 1) result[0] ++;
        }
    }

    public <V> int ex2(DirectGraph<V> g, V root) {
        int[] result = new int[1];
        result[0] = 0;
        Map<V, Integer> count = new HashMap<>();

        NumNodes(g, count, root, result);
        return result[0];
    }

    public List<String> ex3(String start, String end, List<String> dictionary){
        Queue<Pair<String, List<String>>> q = new Queue<>();
        q.enqueue(new Pair<>(start, new ArrayList<>(List.of(start))));

        while (!q.empty()){
            Pair<String, List<String>> dequeue = q.dequeue();
            String word = dequeue.x;
            List<String> path = dequeue.y;

            if (word.equals(end)) return path;

            for (int i=0; i<word.length(); i++) {
                Set<String> visited = new HashSet<>();
                for (String d: dictionary) {
                    if (!visited.contains(d)){
                        String newWord = word.substring(0, i) + word.substring(i+1);
                        String newD = d.substring(0,i) + d.substring(i+1);
                        if (newD.equals(newWord)) {
                            visited.add(d);
                            List<String> path1 = new ArrayList<>(path);
                            path1.add(d);
                            q.enqueue(new Pair(d, path1));
                        }

                    }
                }
            }
        }
        return null;
    }

    public int ex4(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders ) {
        Set<Integer> visited = new HashSet<>();
        int start = 1;
        visited.add(start);
        Queue<Pair<Integer, Integer>> queue = new Queue<>();
        queue.enqueue(new Pair<>(start, 0));

        while(!queue.empty()) {
            Pair<Integer, Integer> dequeue = queue.dequeue();
            start = dequeue.x;
            int steps = dequeue.y;

            if (start == 100) return steps;

            for (int i=1; i<=6; i++) {
                int end = start + i;
                if (snakes.containsKey(end)) {
                    end = snakes.get(end);
                } else if (ladders.containsKey(end)) {
                    end = ladders.get(end);
                }
                if (!visited.contains(end)) {
                    visited.add(end);
                    queue.enqueue(new Pair<>(end, steps + 1));
                }
            }
        }

        return 0;
    }

    public List<String> ex5(DirectGraph<String> g) {
        return g.topologicalSort();
    }
}

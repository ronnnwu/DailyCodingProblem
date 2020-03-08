package chapter16;


import chapter10.DirectGraph;
import chapter2.Pair;

import java.util.*;

public class Chapter16 {

    public Integer ex1(Network<Integer, Integer> nk, Integer start) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = nk.makeGraph();
        Map<Integer, Integer> times = new HashMap<>();
        for (Integer v: nk.getVertices()) {
            times.put(v, Integer.MAX_VALUE);
        }
        times.put(start, 0);

        List<Integer> list = new ArrayList<>(graph.keySet());

        while (list.size() > 0) {
            Integer minRes = Integer.MAX_VALUE;
            Integer minVertic = null;
            for (Integer i: list) {
                if (times.get(i) < minRes) {
                    minRes = times.get(i);
                    minVertic = i;
                }
            }
            list.remove(minVertic);

            for (Pair<Integer, Integer> pair: graph.get(minVertic)) {
                times.put(pair.x, Math.min(times.get(pair.x), times.get(minVertic) + pair.y));
            }
        }

        Integer res = Integer.MIN_VALUE;
        for (Integer i: times.values()) {
             res = Math.max(res, i);
        }
        return res;
    }

    public Integer ex1Soln(Network<Integer, Integer> nk, Integer start) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = nk.makeGraph();
        Map<Integer, Integer> times = new HashMap<>();
        PriorityQueue<NodeTime> pq = new PriorityQueue<>();
        pq.add(new NodeTime(start, 0));

        while(pq.size()>0){
            NodeTime<Integer, Integer> nt = pq.poll();
            if (!times.containsKey(nt.x)) {
                times.put(nt.x, nt.y);
                for (Pair<Integer, Integer> pair:  graph.get(nt.x)){
                    if (!times.containsKey(pair.x)) {
                        pq.add(new NodeTime(pair.x, pair.y + nt.y));
                    }
                }
            }
        }
        Integer res = Integer.MIN_VALUE;
        for (Integer i: times.values()) {
            res = Math.max(res, i);
        }
        return res;
    }

    public boolean ex2(Network<String, Double> nk) {
        Map<String, Map<String, Double>> graph = nk.makeGraphWithLog();
        Map<String, Double> minDist = new HashMap<>();
        for (String s: nk.getVertices()) {
            minDist.put(s, Double.MAX_VALUE);
        }
        minDist.put("USD", 0.0);


        for (int i=0; i<nk.getVertices().size()-1; i++) {
            for (String v: nk.getVertices()) {
                for (String w: nk.getVertices()) {
                    if (!v.equals(w) && (minDist.get(w) > minDist.get(v) + graph.get(v).get(w))) {
                        minDist.put(w, minDist.get(v) + graph.get(v).get(w));
                    }
                }
            }
        }

        for (String v: nk.getVertices()) {
            for (String w: nk.getVertices()) {
                if (!v.equals(w) && (minDist.get(w) > minDist.get(v) + graph.get(v).get(w))) {
                    return true;
                }
            }
        }

        return false;

    }


    public int[][] ex3(DirectGraph<Integer> graph) {

        int n = graph.getVertices().size();
        int[][] res = new int[n][n];

        for (int i =0; i<n; i++) {
            res[i][i] = 1;
        }

        for (Map.Entry<Integer, List<Integer>> entry: graph.getAdjacencyList().entrySet()) {
            for (Integer v: entry.getValue()) {
                res[entry.getKey()][v] = 1;
            }
        }

        for (int k=0; k < n; k++) {
            for (int i=0; i < n; i++) {
                for (int j=0; j < n; j++) {
                    if (res[i][k]==1 && res[k][j]==1){
                        res[i][j] = 1;
                    }
                }
            }
        }

        return res;

    }
}

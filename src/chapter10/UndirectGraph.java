package chapter10;

import chapter2.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UndirectGraph<V> extends Graph<V> {
    List<Pair<V, V>> graph;

    public UndirectGraph(List<Pair<V,V>> graph) {
        this.graph = graph;
        this.adjacencyList = new HashMap<>();

        for(Pair<V,V> e: graph){
            if (adjacencyList.containsKey(e.x)) {
                adjacencyList.get(e.x).add(e.y);
            } else {
                adjacencyList.put(e.x, new ArrayList<>(List.of(e.y)));
            }
            if (adjacencyList.containsKey(e.y)) {
                adjacencyList.get(e.y).add(e.x);
            } else {
                adjacencyList.put(e.y, new ArrayList<>(List.of(e.x)));
            }
        }
    }



}

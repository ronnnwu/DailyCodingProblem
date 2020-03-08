package chapter16;

import chapter2.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network<V, T extends Comparable<T>> {
    private List<V> vertices;
    private List<Triple<V, V, T>> edges;

    public Network(List<V> vertices,  List<Triple<V,V, T>> edges){
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<V> getVertices(){return vertices;}

    public Map<V, List<Pair<V, T>>> makeGraph() {
        Map<V, List<Pair<V, T>>> graph = new HashMap<>();
        for (V v: vertices) {
            graph.put(v, new ArrayList<>());
        }

        for(Triple<V, V, T> triple: edges) {
            graph.get(triple.x).add(new Pair(triple.y, triple.z));
        }
        return graph;
    }

    public Map<V, Map<V, Double>> makeGraphWithLog() {
        Map<V, Map<V, Double>> graph = new HashMap<>();
        for (V v: vertices) {
            graph.put(v, new HashMap<>());
        }

        for(Triple<V, V, T> triple: edges) {
            graph.get(triple.x).put(triple.y, Math.log((Double)triple.z));
        }
        return graph;
    }
}

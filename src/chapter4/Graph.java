package chapter4;

import java.util.*;

public class Graph<T> {
    private Map<T, List<T>> graph;

    public Graph(Map<T, List<T>> adjacencyList) {
        this.graph  =  adjacencyList;
    }
    public Graph(List<T> vertices, List<Pair<T, T>> directEdges) {
        graph = new HashMap<>();
        for (T v: vertices) graph.put(v, new ArrayList<>());
        for (Pair<T, T> p: directEdges) graph.get(p.x).add(p.y);
    }


    private boolean isConnectedDfs(Set<T> visited, T source, T sink) {
        if (!graph.containsKey(source)) return false;
        if (source.equals(sink)) return true;
        visited.add(source);
        for (T adj: graph.get(source)) {
            if (!visited.contains(adj)) {
                if (isConnectedDfs(visited, adj, sink)) return true;
            }
        }
        return false;
    }

    public boolean isConnected(T source, T sink){
        Set<T> visited = new HashSet<>();
        return isConnectedDfs(visited, source, sink);
    }

    private void topologicalSortDfs(Set visited, List<T> result, T source) {
        visited.add(source);
        if (graph.containsKey(source)){
            for (T v: graph.get(source)) {
                if (! visited.contains(v)) topologicalSortDfs(visited, result, v);
            }
        }
        result.add(source);
    }

    public List<T> topologicalSort() {
        Set<T> visited = new HashSet<>();
        List<T> result = new ArrayList<>();
        for (T v: graph.keySet()) {
            if (! visited.contains(v)) topologicalSortDfs(visited, result, v);
        }
        return result;
    }

}

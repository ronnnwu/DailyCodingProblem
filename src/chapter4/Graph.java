package chapter4;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
    private Map<T, List<T>> graph;

    public Graph(Map<T, List<T>> adjacencyList) {
        this.graph  =  adjacencyList;
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

}

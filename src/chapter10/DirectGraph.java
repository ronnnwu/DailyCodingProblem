package chapter10;

import chapter2.Pair;

import java.util.*;

public class DirectGraph<V> extends Graph<V> {
    List<Pair<V, V>> graph;

    public DirectGraph(List<Pair<V,V>> graph) {
        this.graph = graph;
        this.adjacencyList = new HashMap<>();

        for(Pair<V,V> e: graph){
            if (adjacencyList.containsKey(e.x)) {
                adjacencyList.get(e.x).add(e.y);
            } else {
                adjacencyList.put(e.x, new ArrayList<>(List.of(e.y)));
            }
        }
    }

    public List<V> topologicalSort() {
        Set<V> visited = new HashSet<>();
        List<V> result = new ArrayList<>();
        for (V v: adjacencyList.keySet()) {
            if (!visited.contains(v)){
                dfs(visited, v, result);
            }
        }
        return result;
    }

    private void dfs(Set<V> visited, V v, List<V> result) {
        visited.add(v);
        if (!adjacencyList.containsKey(v) || adjacencyList.get(v).size()==0) {
            result.add(v);
            return;
        }
        for (V neighbor: adjacencyList.get(v)) {
            if (!visited.contains(neighbor)) {
                dfs(visited, neighbor, result);
            }
        }
        result.add(v);
    }
}

package chapter10;


import java.util.*;

public class Graph<V> {

    Map<V, List<V>> adjacencyList;

    private boolean isCycleUtil(V u, Set<V>  visited, V parent){

        visited.add(u);

        for(V v: this.adjacencyList.get(u)) {
            if(!visited.contains(v)){
                if (isCycleUtil(v, visited, u)) return true;
            }
            else if(v != parent){
                return true;
            }
        }

        return false;
    }

    public Map<V, List<V>> getAdjacencyList() {return adjacencyList;};
    public Set<V> getVertices() {
        HashSet hashSet = new HashSet(adjacencyList.keySet());
        for(List<V> values: adjacencyList.values()){
            hashSet.addAll(values);
        }
        return hashSet;
    }

    public boolean isCyclic(){
        Set<V> visited = new HashSet();

        for(V v: adjacencyList.keySet()) {
            if (!visited.contains(v)) {
                if (isCycleUtil(v, visited, null)) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }
}

package chapter10;

import chapter4.Queue;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


    public boolean isCyclic(){
        Set<V> visited = new HashSet();

        for(V v: adjacencyList.keySet()) {
            if (!visited.contains(v)) {
                if (isCycleUtil(v, visited, null)) return true;
            }
        }
        return false;
    }
}

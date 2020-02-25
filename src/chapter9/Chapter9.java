package chapter9;

import chapter2.Pair;

import java.util.*;

public class Chapter9 {

    private void add(int i, MinHeap<Integer> minHeap, MinHeap<Integer> maxHeap) {
        if (minHeap.size()==0 && maxHeap.size()==0) {
            minHeap.insert(i);
            return;
        }
        Double median = getMedian(minHeap, maxHeap);
        if (i > median) {
            minHeap.insert(i);
        } else {
            maxHeap.insert(-1*i);
        }
    }

    private void rebalance(MinHeap<Integer> minHeap, MinHeap<Integer> maxHeap) {
        if (minHeap.size()>maxHeap.size()+1) {
            int min = minHeap.extractMin();
            maxHeap.insert(-1*min);
        } else if (maxHeap.size()>minHeap.size()+1) {
            int max = -1*maxHeap.extractMin();
            minHeap.insert(max);
        }
    }

    private Double getMedian(MinHeap<Integer> minHeap, MinHeap<Integer> maxHeap) {
        if (minHeap.size()>maxHeap.size()) return 1.0*minHeap.getMin();
        if (minHeap.size()<maxHeap.size()) return -1.0* maxHeap.getMin();
        return (minHeap.getMin()-maxHeap.getMin())/2.0;
    }

    public List<Double> ex1(List<Integer> list) {

        MinHeap<Integer> minHeap =  new MinHeap<>();
        MinHeap<Integer> maxHeap =  new MinHeap<>();
        List<Double> result = new ArrayList<>();

        for (int i: list) {
            add(i, minHeap, maxHeap);
            rebalance(minHeap, maxHeap);
            result.add(getMedian(minHeap, maxHeap));
        }

        return result;
    }

    private Double computeSimilarity(String s1, String s2, Map<String, Set<Integer>> visitors) {
        Set<Integer> sIntersect = new HashSet(visitors.get(s1));
        sIntersect.retainAll(visitors.get(s2));
        Set<Integer> sUnion = new HashSet(visitors.get(s1));
        sUnion.addAll(visitors.get(s2));
        return (1.0*sIntersect.size())/sUnion.size();
    }

    
    public MinHeap<Pairs> ex2(List<Pair<String, Integer>> log, int k){
        Map<String, Set<Integer>> visitors = new HashMap<>();
        for (Pair<String, Integer> p : log) {
            if (visitors.containsKey(p.x)) {
                visitors.get(p.x).add(p.y);
            } else {
                visitors.put(p.x, new HashSet<>(Set.of(p.y)));
            }
        }

        MinHeap<Pairs> pairs = new MinHeap<>();
        List<String> sites =  new ArrayList(visitors.keySet());

        for (int i=0; i<k; i++) {
            pairs.insert(new Pairs(0.0, new Pair("", "")));
        }

        for (int i=0;i<sites.size()-1; i++){
            for (int j=i+1; j< sites.size(); j++){
                Double score = computeSimilarity(sites.get(i), sites.get(j), visitors);
                pairs.insert(new Pairs(score, new Pair(sites.get(i), sites.get(j))));
                pairs.extractMin();
            }
        }

        return pairs;
    }


    public List<Integer> ex3(int n) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(1);
        int last = 0;
        int count = 0;
        List<Integer> result = new ArrayList<>();

        while(count < n) {
            int x = minHeap.extractMin();
            if (x > last) {
                last = x;
                count ++;
                result.add(x);
                minHeap.insert(2*x);
                minHeap.insert(3*x);
                minHeap.insert(5*x);
            }
        }
        return result;
    }

}

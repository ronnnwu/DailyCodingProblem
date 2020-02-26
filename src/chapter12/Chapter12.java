package chapter12;

import chapter2.Pair;

import java.util.List;

public class Chapter12 {

    private void towerOfHanoi(int n, char a, char b, char c) {
        if (n>=1) {
            towerOfHanoi(n-1, a, c, b);
            System.out.println("move " + a + " to " + c);
            towerOfHanoi(n-1, b, a, c);
        }
    }


    public void ex1(int n) {
        towerOfHanoi(n, 'a', 'b', 'c');
    }

    public boolean ex2(String r, String s) {
        if (r.length()==0) return s.length() == 0;
        if (r.length() == 1) {
            if (r.equals(".")) return s.length() ==1;
            if (r.equals("*")) return true;
            return r.equals(s);
        }
        if (r.charAt(0) == '.') {
            return ex2(r.substring(1), s.substring(1));
        }
        if (r.charAt(0) == '*') {
            for (int i =0; i<s.length(); i++) {
                if (ex2(r.substring(1), s.substring(i))) return true;
            }
        }
        if (r.charAt(0) != s.charAt(0)) return false;
        return ex2(r.substring(1), s.substring(1));

    }

    public Pair<Integer, Integer> ex3(List<Integer> arr) {
        int max = arr.get(0);
        int min = arr.get(0);

        if (arr.size() % 2 ==0) {
            arr.add(arr.get(arr.size()-1));
        }
        for (int i =1; i<arr.size(); i+=2) {
            int small;
            int big;
            if (arr.get(i) < arr.get(i+1)){
                small = arr.get(i);
                big = arr.get(i+1);
            } {
                small = arr.get(i+1);
                big = arr.get(i);
            }
            max = Math.max(big, max);
            min = Math.min(small, min);
        }
        return new Pair<>(min, max);
    }

    public Pair<Integer, Integer> ex3Soln(List<Integer> arr) {
        if (arr.size() ==1) return new Pair<>(arr.get(0), arr.get(0));
        if (arr.size() ==2) return arr.get(0)<arr.get(0)? new Pair<>(arr.get(0), arr.get(1)): new Pair<>(arr.get(1), arr.get(0));

        int n = arr.size() /2 ;
        Pair<Integer, Integer> left = ex3Soln(arr.subList(0, n));
        Pair<Integer, Integer> right = ex3Soln(arr.subList(n, arr.size()));

        return new Pair<>(Math.min(left.x, right.x), Math.max(left.y, right.y));
    }

}

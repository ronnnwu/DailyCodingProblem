package chapter2;

import java.util.*;

public class Chapter2 {
    public List<Integer> ex1(String w, String s){
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : w.toCharArray()){
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        for (int i = 0; i < w.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == 1) map.remove(c);
                else map.put(c, map.get(c) - 1);
            }
            else map.put(c, -1);
        }

        if (map.size() == 0) result.add(0);

        for (int i = 0; i<s.length()-w.length(); i++) {
            char removeChar = s.charAt(i);
            char addChar = s.charAt(i+w.length());

            if (map.containsKey(removeChar)) {
                if (map.get(removeChar) == -1) map.remove(removeChar);
                else map.put(removeChar, map.get(removeChar) + 1);
            }
            else map.put(removeChar, 1);

            if (map.containsKey(addChar)) {
                if (map.get(addChar) == 1) map.remove(addChar);
                else map.put(addChar, map.get(addChar) - 1);
            }
            else map.put(addChar, -1);

            if (map.size() == 0) {
                result.add(i+1);
            }
        }

        return result  ;
    }

    public List<Pair<Integer, Integer>> ex2(String[] a){
        Map<String, Integer> d = new HashMap<>();
        for (int i =0;  i < a.length; i++) {
            d.put(a[i], i);
        }
        List<Pair<Integer, Integer>> result = new ArrayList<>();

        for (int i = 0;  i < a.length; i++) {
            String s = a[i];
            for (int j=0; j<s.length(); j++) {
                String prefix = s.substring(0,j);
                String suffix = s.substring(j);

                String prefixReverse = new StringBuffer(prefix).reverse().toString();
                String suffixReverse = new StringBuffer(suffix).reverse().toString();

                if (d.containsKey(prefixReverse) && suffix!= null && suffix.equals(suffixReverse) && d.get(prefixReverse)!= i)
                    result.add(new Pair<>(i, d.get(prefixReverse)));
                if (d.containsKey(suffixReverse) && prefix!= null && prefix.equals(prefixReverse) && d.get(suffixReverse)!= i)
                    result.add(new Pair<>(d.get(suffixReverse), i));
            }
        }

        return result;
    }

    public int getSpaces (int row, boolean desc, int k) {
        int maxSpace = (k-1) * 2 -1;
        return desc? maxSpace - row * 2 : maxSpace - (k-1-row)*2;
    }

    public void ex3(String s, int k) {
        for (int i = 0; i<k; i++) {
            int j = i;
            for (int l=0; l<i; l++) System.out.print(" ");
            while (j<s.length()) {
                System.out.print(s.charAt(j));
                int space = getSpaces(i, j % (2*(k-1)) < k-1, k );
                for (int l=0; l<space; l++) System.out.print(" ");
                j += space + 1;
            }
            System.out.println();
        }
    }

    public String ex4(String s, int k) {
        if (k==1) {
            String best = s;
            for (int i=0; i<s.length();i++) {
                String newS = s.substring(i) + s.substring(0, i);
                best = newS.compareTo(best) < 0? newS: best;
            }
            return best;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

}

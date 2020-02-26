package chapter13;

public class Chapter13 {
    public int ex1(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        return ex1(n-1) + ex1(n-2);
    }

    public int ex1soln(int n) {
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;

        for (int i=3; i<=n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public int ex2(String s){
        if (s.length()==0) return 0;
        if (s.length()==1) return 1;
        if (s.length()==2) return Integer.parseInt(s)<=26?2:1;

        if (Integer.parseInt(s.substring(0,2))<=26) {
            return ex2(s.substring(1)) + ex2(s.substring(2));
        }
        return ex2(s.substring(1));
    }

    public int ex2soln(String s) {
        int[] cache = new int[s.length()];
        cache[s.length()-1] = 1;
        cache[s.length()-2] = Integer.parseInt(s.substring(s.length()-2))<=26?2:1;

        for (int i=s.length()-3; i>=0; i--) {
            cache[i] = cache[i+1];
            if (Integer.parseInt(s.substring(i, i+2))<=26) cache[i] += cache[i+2];
        }
        return cache[0];
    }
}

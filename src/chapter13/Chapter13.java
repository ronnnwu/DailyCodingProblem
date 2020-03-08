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

    private int _ex3(int[][] cost, int house, int color) {
        if (house == cost.length) return 0;
        int result = Integer.MAX_VALUE;
        for (int c=0; c<cost[0].length; c++) {
            if (c != color)
                result = Math.min(result, cost[house][color] + _ex3(cost, house+1, c));
        }
        return result;
    }

    public int ex3(int[][] cost) {
        int result = Integer.MAX_VALUE;
        for (int c=0; c<cost[0].length; c++) {
            result = Math.min(result, _ex3(cost, 0, c));
        }
        return result;
    }

    public int ex3Soln(int[][] cost) {
        int n = cost.length;
        int k = cost[0].length;

        int[] solution = new int[k];

        for (int r =0; r<n; r++) {
            int[] newRow = new int[k];

            for (int c = 0; c<k; c++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j<k; j++) {
                    if (j != c) {
                        min = Math.min(solution[j]+cost[r][c], min);
                    }
                }
                newRow[c] = min;
            }
            solution = newRow;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j<k; j++) {
            min = Math.min(solution[j], min);
        }
        return min;
    }

}

package chapter1;

import java.util.ArrayList;
import java.util.List;

public class Chapter1 {

    public int[] ex1(int[] arr) {
        int[] prefixProduct = new int[arr.length];
        int[] suffixProduct = new int[arr.length];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i ==0) prefixProduct[i] = arr[i];
            else prefixProduct[i] = prefixProduct[i-1] * arr[i];
        }

        for (int i = arr.length -1 ; i>=0;  i--) {
            if (i ==arr.length -1) suffixProduct[i] = arr[i];
            else suffixProduct[i] = suffixProduct[i+1] * arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (i==0) result[i] = suffixProduct[i+1];
            else if (i==arr.length-1) result[i] = prefixProduct[i-1];
            else result[i] = prefixProduct[i-1] * suffixProduct[i+1];
        }
        return result;
    }


    public int[] ex2(int[] arr) {
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (arr[i] < max) {
                res[1] = i;
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            min = Math.min(min, arr[i]);
            if (arr[i] > min) {
                res[0] = i;
            }
        }
        return res;
    }

    public int ex3(int[] arr) {
        int res = Integer.MIN_VALUE;
        int runningmax = Integer.MIN_VALUE;
        for (int i= 0; i<arr.length; i++){
            runningmax = Math.max(runningmax + arr[i], arr[i]);
            res = Math.max(res, runningmax);
        }
        return res;
    }

    private int indexArr_helper(int[] arr, int elm, int l, int r) {
        if ( r<= l) return l;
        int m = l + (r-l)/2;
        if (m!=0 && arr[m-1]<elm && arr[m]>=elm) return m;
        if (arr[m] < elm) return indexArr_helper(arr, elm, m+1, r);
        return indexArr_helper(arr, elm, l, m-1);
    }

    public int indexArr(int[] arr, int elm) {
        if (arr.length==0 || elm < arr[0]) return 0;
        if (elm > arr[arr.length-1]) return arr.length;
        return indexArr_helper(arr, elm, 0, arr.length-1);
    }


    public int[] ex4(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[arr.length];
        for (int i = arr.length -1; i >= 0; i--){
            int idx = indexArr(list.stream().mapToInt(n -> n).toArray(), arr[i]);
            res[i] = idx;
            list.add(idx, arr[i]);
        }
        return res;
    }
}

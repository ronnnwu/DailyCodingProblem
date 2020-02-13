package chapter1;

public class Exercise {

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
        return 0;
    }

    public int[] ex4(int[] arr) {
        return null;
    }
}

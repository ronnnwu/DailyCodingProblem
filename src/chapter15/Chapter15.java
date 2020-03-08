package chapter15;

import java.util.ArrayList;
import java.util.List;

public class Chapter15 {

    private void swap(char[] arr, int i, int j){
        char c =  arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public void ex1(char[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length -1;

        while(mid<=high){
            if (arr[mid] == 'R') {
                swap(arr, low, mid);
                low ++;
                mid ++;
            } else if(arr[mid]=='G') {
                mid ++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private void reverse(int[] arr, int i, int j){
        while(i<j){
            int c =  arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }

    public void ex2(int[] arr){
        for (int i=arr.length-1; i>=0; i-- ){
            int maxIdx = maxPos(arr, i+1);
            reverse(arr, 0, maxIdx);
            reverse(arr, 0, i);
        }
    }

    private int maxPos(int[] arr, int i) {
        int res = arr[0];
        int ind = 0;
        for (int j=0; j<i; j++ ){
            if (res < arr[j]){
                res = arr[j];
                ind = j;
            }
        }
        return ind;
    }



    public int[] ex3(int[] arr, int digit) {
        for (int i=0; i<digit; i++) {
            arr = countingSort(arr, i);
        }
        return arr;
    }

    private int[] countingSort(int[] arr, int digit) {
        List<List<Integer>> counts = new ArrayList<>();
        for (int i=0; i<10; i++) counts.add(new ArrayList<>());

        for (int n: arr) {
            int d = ( n / (int)Math.pow(10, digit)) % 10;
            counts.get(d).add(n);
        }

        List<Integer> result = new ArrayList<>();
        for (List<Integer> buckets : counts) {
            result.addAll(buckets);
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public Integer ex4(int[] arr, int num) {
        int i = arr.length /2 ;
        int dist = i / 2;
        while (true) {
            if (arr[0] > arr [i] && arr[i-1] > arr[i]) break;
            else if (dist == 0) break;
            else if (arr[0] <= arr[i]) i = i + dist;
            else if (arr[i-1] <= arr[i]) i = i - dist;
            else break;
            dist = dist / 2;
        }

        int low = i;
        int high = i-1;
        dist = arr.length /2 ;
        while(true) {
            if (dist ==0) return null;
            int guessIdx = (low + dist) % arr.length;
            if (arr[guessIdx] == num) return guessIdx;
            if (arr[guessIdx]<num) low = (low + dist) % arr.length;
            else if (arr[guessIdx]>num) high = (arr.length + high - dist) % arr.length;
            dist = dist / 2;
        }

    }
}

package chapter15;

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

    }
}

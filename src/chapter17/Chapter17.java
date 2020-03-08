package chapter17;

public class Chapter17 {

    public int ex1(int[] arr) {
        int[] resultArr = new int[32];
        for (int a : arr) {
            for (int i=0; i<32; i++) {
                int bit = a >> i & 1;
                resultArr[i] += bit;
            }
        }

        int result = 0;

        for (int i=0; i<32; i++) {
            if (resultArr[i] %3!=0) {
                result += Math.pow(2,i);
            }
        }
        return result;
    }
}

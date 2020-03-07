package chapter11;

public class BIT {

    private int[] tree;
    public BIT(int[] arr) {
        tree = new int[arr.length+1];
        for (int i= 0; i< arr.length; i++) {
            this.update(i+1, arr[i]);
        }
    }

    public void update(int index, int value) {
        while (index<tree.length) {
            tree[index] += value;
            index += index & -index;
        }
    }

    public int query(int index) {
        int total = 0;
        while(index>0) {
            total += tree[index];
            index -= index & -index;
        }
        return total;
    }
}

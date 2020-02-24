package chapter4;

public class MaxStackElement<T extends Comparable<T>> extends StackElement<T>{
    public T runningMax;

    public MaxStackElement(T data, T runningMax) {
        super(data);
        this.runningMax = runningMax;
    }
}

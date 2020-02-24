package chapter4;

public class StackElement<T> {
    public T data;

    public  StackElement(T data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}

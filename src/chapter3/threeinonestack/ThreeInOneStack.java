package chapter3.threeinonestack;


import java.util.ArrayList;
import java.util.List;

public class ThreeInOneStack<T> {

    private List<T> arr = new ArrayList<>();
    private int[] size = new int[3];

    public class Stack {

        private final StackOneTwoThree type;

        public Stack(StackOneTwoThree type) {
            this.type = type;
        }

        public int size() {
            switch (type) {
                case STACK_ONE:
                    return size[0];
                case STACK_TWO:
                    return size[1];
                case STACK_THREE:
                    return size[2];
                default:
                    return 0;
            }
        }

        public void push(T t){
            int reserve = Math.max(Math.max(size[0], size[1]), size[2]) * 3 + 3;
            if (arr.size() < reserve) {
                for (int i = 0; i<=reserve-arr.size(); i++) arr.add(null);
            }
            switch (type) {
                case STACK_ONE:
                    arr.set(size[0]*3, t);
                    size[0] ++;
                    return;
                case STACK_TWO:
                    arr.set(size[1]*3+1, t);
                    size[1] ++;
                    return;
                case STACK_THREE:
                    arr.set(size[2]*3+2, t);
                    size[2] ++;
                    return;
                default:
                    return;
            }
        }

        public T pop() {
            switch (type) {
                case STACK_ONE:
                    if (size[0] == 0) return null;
                    size[0] --;
                    return arr.get(size[0] * 3);
                case STACK_TWO:
                    if (size[1] == 0) return null;
                    size[1] --;
                    return arr.get(size[1]*3+1);
                case STACK_THREE:
                    if (size[2] == 0) return null;
                    size[2] --;
                    return arr.get(size[2]*3+2);
                default:
                    return null;
            }
        }

        public T peek() {
            switch (type) {
                case STACK_ONE:
                    return arr.get(size[0]*3-3);
                case STACK_TWO:
                    return arr.get(size[1]*3-2);
                case STACK_THREE:
                    return arr.get(size[2]*3-1);
                default:
                    return null;
            }
        }

    }

}

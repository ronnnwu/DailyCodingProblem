package chapter3;

import java.util.Stack;

public class SortedStack extends Stack<Integer> {

    @Override
    public Integer push(Integer item) {
        if (super.empty()) return super.push(item);
        Stack<Integer> tmp =  new Stack();
        while(!super.empty() && super.peek()<item) {
            tmp.push(super.pop());
        }
        super.push(item);
        while(!tmp.empty()) super.push(tmp.pop());
        return item;
    }
}

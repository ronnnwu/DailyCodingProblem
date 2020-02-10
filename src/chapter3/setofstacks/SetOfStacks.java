package chapter3.setofstacks;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks {

    private List<SmallStack> stacks = new ArrayList<>();

    public boolean empty() {
        for (SmallStack stack: stacks) {
            if (!stack.empty()) return false;
        }
        return true;
    }

    public void push(int data) {
        if (stacks.size() == 0 || stacks.get(stacks.size()-1).full()) {
            SmallStack stack = new SmallStack();
            stack.push(data);
            stacks.add(stack);
        } else {
            stacks.get(stacks.size()-1).push(data);
        }
    }

    public int popAt(int index) {
        if (index>=0 && index<stacks.size()) return stacks.get(index).pop();
        throw new IndexOutOfBoundsException();
    }

    public int pop() {
        for (int i=stacks.size(); i>0; i--){
            if(!stacks.get(i-1).empty()) return stacks.get(i-1).pop();
        }
        throw new EmptyStackException();
    }

}


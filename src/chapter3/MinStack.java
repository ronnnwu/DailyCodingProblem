package chapter3;

import java.util.Stack;

public class MinStack extends Stack<Integer> {
     private Stack<Integer> minStack = new Stack();

     public void push(int data) {
         if (super.empty() || data <= this.min()) {
             minStack.push(data);
         }
         super.push(data);
     }

     public Integer pop() {
         if (super.empty()) return null;
         int data = super.pop();
         if (data == min()) minStack.pop();
         return data;
     }

     public Integer min() {
         if (minStack.size() == 0) return null;
         return minStack.peek();
     }
}

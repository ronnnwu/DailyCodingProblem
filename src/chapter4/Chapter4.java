package chapter4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter4 {

    public void ex1(){
        MaxStack stack = new MaxStack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(5);

        System.out.println(stack.max());
        System.out.println(stack.pop());
        System.out.println(stack.max());
    }

    public boolean ex2(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c: s.toCharArray()) {
            if (c=='[' || c=='{' || c=='(')
                stack.push(c);
            else {
                if (stack.empty()) return false;
                char c1 = stack.pop();
                if (map.get(c1) != c) return false;
            }
        }
        return stack.empty();
    }

    public void ex3(int[] arr, int k) {
        Deque<Integer> q = new Deque<>();
        for (int i=0; i<k; i++) {
            while (!q.empty() && arr[i] >= arr[q.peek()]) {
                q.pop();
            }
            q.enqueue(i);
        }

        for (int i=k; i<arr.length; i++) {
            System.out.print(arr[q.peekLeft()]+ " ");
            while(!q.empty() && q.peekLeft() <= i-k) {
                q.popleft();
            }
            while(!q.empty() && arr[i] >= arr[q.peek()]) {
                q.pop();
            }
            q.enqueue(i);
        }
        System.out.print(arr[q.peekLeft()]);
        System.out.println();
    }

    public List<Integer> ex4(char[] arr) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i =0; i<arr.length-1; i++) {
            if (arr[i+1] =='-') stack.push(i);
            else {
                ans.add(i);
                while(!stack.empty()) {
                    ans.add(stack.pop());
                }
            }
        }
        stack.push(arr.length-1);
        while(!stack.empty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}

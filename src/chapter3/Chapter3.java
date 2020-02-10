package chapter3;

import chapter3.animalshelter.AnimalShelter;
import chapter3.animalshelter.Cat;
import chapter3.animalshelter.Dog;
import chapter3.setofstacks.SetOfStacks;
import chapter3.threeinonestack.ThreeInOneStack;

import static chapter3.threeinonestack.StackOneTwoThree.*;

public class Chapter3 {
    public void Ex1(){
        ThreeInOneStack<Integer>.Stack stack1 = new ThreeInOneStack<Integer>().new Stack(STACK_ONE);
        ThreeInOneStack.Stack stack2 = new ThreeInOneStack().new Stack(STACK_TWO);
        ThreeInOneStack.Stack stack3 = new ThreeInOneStack().new Stack(STACK_THREE);

        stack1.push(10);
        stack1.push(11);
        stack1.push(12);
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());

        System.out.println(stack1.size());


        stack2.push(1);
        stack2.push(2);
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());

    }

    public void Ex2() {
        MinStack stack = new MinStack();

        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }

    public void Ex3() {
        SetOfStacks stack = new SetOfStacks();

        for(int i=0; i<10; i++) stack.push(i);

        System.out.println(stack.pop());
        System.out.println(stack.popAt(1));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    public void Ex4() {
        MyQueue queue = new MyQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

    public void Ex5() {
        SortedStack stack = new SortedStack();

        stack.push(12);
        stack.push(4);
        stack.push(2);
        stack.push(20);
        stack.push(11);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public void Ex6() {
        AnimalShelter as = new AnimalShelter();

        as.enqueue(new Dog("Bella D"));
        as.enqueue(new Cat("Charlie C"));
        as.enqueue(new Cat("Luna C"));
        as.enqueue(new Dog("Lucy D"));
        as.enqueue(new Dog("Max D"));
        as.enqueue(new Cat("Bailey C"));
        as.enqueue(new Cat("Cooper C"));
        as.enqueue(new Dog("Daisy D"));


        System.out.println(as.dequeueCat().getName());
        System.out.println(as.dequeueCat().getName());

        System.out.println(as.dequeueDog().getName());
        System.out.println(as.dequeue().getName());
    }

}

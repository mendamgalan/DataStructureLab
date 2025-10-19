package lab3;

import dataStructures.ArrayLinearList;
import dataStructures.Stack;

public class MyStack extends ArrayLinearList implements Stack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        MyStack otherStack = new MyStack();
        otherStack.push(5);
        otherStack.push(6);

        stack.combineStack(otherStack);
        System.out.println("Top after combine: " + stack.peek());

        MyStack[] halves = stack.splitStack();
        System.out.println("First half top: " + halves[0].peek());
        System.out.println("Second half top: " + halves[1].peek());
    }

    public boolean empty() {
        return super.isEmpty();
    }

    public Object peek() {
        return get(size() - 1);
    }

    public void push(Object theObject) {
        add(size(), theObject);
    }

    public Object pop() {
        return remove(size() - 1);
    }

    public void combineStack(MyStack otherStack) {
        MyStack temp = new MyStack();
        while (!otherStack.empty()) {
            temp.push(otherStack.pop());
        }
        while (!temp.empty()) {
            this.push(temp.pop());
        }
    }

    public MyStack[] splitStack() {
        int halfSize = size() / 2;
        MyStack firstHalf = new MyStack();
        MyStack secondHalf = new MyStack();
        MyStack temp = new MyStack();
        while (!empty()) {
            temp.push(this.pop());
        }
        for (int i = 0; i < halfSize; i++) {
            firstHalf.push(temp.pop());
        }
        while (!temp.empty()) {
            secondHalf.push(temp.pop());
        }
        return new MyStack[]{firstHalf, secondHalf};
    }
}

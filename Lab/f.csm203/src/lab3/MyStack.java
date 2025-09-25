package lab3;

import dataStructures.ArrayLinearList;
import dataStructures.Stack;

public class MyStack extends ArrayLinearList implements Stack {
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

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

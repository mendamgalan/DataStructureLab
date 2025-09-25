package lab3;

import dataStructures.Stack;

import java.util.Scanner;

public class MyStackArrayImplemented {
    int[] stack;
    int top;

    MyStackArrayImplemented(int size) {
        stack = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(int theObject) {
        if (isFull()) {
            System.out.println("Stack overflow");
        } else {
            stack[++top] = theObject;
            System.out.println("Pushed: " + theObject);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack empty");
        }
        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements (top -> bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        MyStackArrayImplemented stack = new MyStackArrayImplemented(size);

        while (true) {
            System.out.println("\n--- Stack Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped != -1) System.out.println("Popped: " + popped);
                    break;
                case 3:
                    int topValue = stack.peek();
                    if (topValue != -1) System.out.println("Top element: " + topValue);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

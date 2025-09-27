package lab3;

import java.util.Scanner;

public class MyStackArrayImplemented {
    int[] stack;
    int top;

    MyStackArrayImplemented(int size) {
        stack = new int[size];
        top = -1;
    }

    public int getSize() {
        return stack.length;
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
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack empty");
            return -1;
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

    public void combineStack(MyStackArrayImplemented otherStack) {
        MyStackArrayImplemented temp = new MyStackArrayImplemented(otherStack.getSize());
        while (!otherStack.isEmpty()) {
            temp.push(otherStack.pop());
        }
        while (!temp.isEmpty()) {
            if (this.isFull()) {
                System.out.println("Cannot combine: stack overflow!");
                break;
            }
            this.push(temp.pop());
        }
    }

    public MyStackArrayImplemented[] splitStack() {
        int halfSize = (top + 1) / 2;
        MyStackArrayImplemented first = new MyStackArrayImplemented(halfSize);
        MyStackArrayImplemented second = new MyStackArrayImplemented(top + 1 - halfSize);
        MyStackArrayImplemented temp = new MyStackArrayImplemented(top + 1);
        while (!isEmpty()) {
            temp.push(pop());
        }
        for (int i = 0; i < halfSize; i++) {
            first.push(temp.pop());
        }
        while (!temp.isEmpty()) {
            second.push(temp.pop());
        }
        return new MyStackArrayImplemented[]{first, second};
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
            System.out.println("5. Combine with another stack");
            System.out.println("6. Split stack");
            System.out.println("7. Exit");
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
                    System.out.print("Enter size of other stack: ");
                    int otherSize = sc.nextInt();
                    MyStackArrayImplemented otherStack = new MyStackArrayImplemented(otherSize);
                    System.out.println("Enter elements of other stack:");
                    for (int i = 0; i < otherSize; i++) {
                        otherStack.push(sc.nextInt());
                    }
                    stack.combineStack(otherStack);
                    stack.display();
                    break;
                case 6:
                    MyStackArrayImplemented[] splitStacks = stack.splitStack();
                    System.out.println("First half:");
                    splitStacks[0].display();
                    System.out.println("Second half:");
                    splitStacks[1].display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

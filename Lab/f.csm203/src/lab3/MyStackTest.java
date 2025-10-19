package lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    @Test
    void testCombineStack() {
        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);

        MyStack stack2 = new MyStack();
        stack2.push(3);
        stack2.push(4);

        stack1.combineStack(stack2);

        assertEquals(4, stack1.peek());
        assertTrue(stack2.empty());
    }

    @Test
    void testSplitStackEven() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        MyStack[] halves = stack.splitStack();

        assertEquals(2, halves[0].size());
        assertEquals(2, halves[1].size());

        assertEquals(2, halves[0].peek());
        assertEquals(4, halves[1].peek());
    }

    @Test
    void testSplitStackOdd() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        MyStack[] halves = stack.splitStack();

        assertEquals(2, halves[0].size());
        assertEquals(3, halves[1].size());

        assertEquals(2, halves[0].peek());
        assertEquals(5, halves[1].peek());
    }
}

package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyChainTest {

    @Test
    public void testToArray() {
        MyChain chain = new MyChain();
        chain.add(0, 1);
        chain.add(1, 2);
        chain.add(2, 3);

        Object[] expected = {1, 2, 3};
        assertArrayEquals(expected, chain.toArray(), "toArray() should return [1, 2, 3]");
    }

    @Test
    public void testAddRange() {
        MyChain chain = new MyChain();
        chain.add(0, 1);
        chain.add(1, 2);

        Object[] more = {3, 4, 5};
        chain.addRange(more);

        Object[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, chain.toArray(), "addRange() should append new elements");
    }

    @Test
    public void testUnion() {
        MyChain A = new MyChain();
        A.add(0, 1);
        A.add(1, 3);
        A.add(2, 4);

        MyChain B = new MyChain();
        B.add(0, 3);
        B.add(1, 4);
        B.add(2, 5);

        MyChain union = A.union(B);
        Object[] expected = {1, 3, 4, 5};
        assertArrayEquals(expected, union.toArray(), "Union should combine unique elements");
    }

    @Test
    public void testIntersection() {
        MyChain A = new MyChain();
        A.add(0, 1);
        A.add(1, 3);
        A.add(2, 4);

        MyChain B = new MyChain();
        B.add(0, 3);
        B.add(1, 4);
        B.add(2, 5);

        MyChain intersection = A.intersection(B);
        Object[] expected = {3, 4};
        assertArrayEquals(expected, intersection.toArray(), "Intersection should return only common elements");
    }
}


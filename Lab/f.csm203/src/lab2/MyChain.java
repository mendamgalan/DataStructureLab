package lab2;

import dataStructures.Chain;

public class MyChain extends Chain {
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    public void addRange(Object[] elements) {
        for (Object element : elements) {
            this.add(size(), element);
        }
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size(); i++) {
            if (this.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public MyChain union(MyChain other) {
        MyChain union = new MyChain();
        for (int i = 0; i < size(); i++) {
            if (!union.contains(this.get(i))) {
                union.add(union.size(), this.get(i));
            }
        }
        for (int i = 0; i < other.size(); i++) {
            if (!union.contains(other.get(i))) {
                union.add(union.size(), other.get(i));
            }
        }
        return union;
    }

    public MyChain intersection(MyChain other) {
        MyChain intersection = new MyChain();
        for (int i = 0; i < size(); i++) {
            if (this.contains(other.get(i)) && !intersection.contains(other.get(i))) {
                intersection.add(intersection.size(), other.get(i));
            }
        }
        return intersection;
    }

}

package lab1;

import dataStructures.ArrayLinearList;

public class MyArrayLinearList extends ArrayLinearList {
    public int max() {
        int max = (int) element[0];
        for (int i = 1; i < size; i++) {
            if ((int) element[i] > max) {
                max = (int) element[i];
            }
        }
        return max;
    }

    public int min() {
        int min = (int) element[0];
        for (int i = 1; i < size; i++) {
            if ((int) element[i] < min) {
                min = (int) element[i];
            }
        }
        return min;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += (int) this.get(i);
        }
        return sum;
    }

    public double average() {
        return (double) sum() / size;
    }

    public void removeOdd() {
        for (int i = size - 1; i >= 0; i--) {
            if ((int) element[i] % 2 != 0) {
                remove(i);
            }
        }
    }

    public void sort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                Integer a = (Integer) element[j];
                Integer b = (Integer) element[j + 1];
                if (a > b) {
                    swapped = true;
                    element[j] = b;
                    element[j + 1] = a;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}


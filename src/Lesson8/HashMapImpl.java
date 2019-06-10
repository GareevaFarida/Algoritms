package Lesson8;

import java.util.Arrays;

public class HashMapImpl<E> implements HashMap<E> {
    private int size = 0;
    private int capacity = 16;
    private E[] data;

    public HashMapImpl(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    private boolean isFull() {
        return data.length == capacity;
    }

    private void grow() {
        E[] bigData = (E[]) new Object[capacity * 2];
        System.arraycopy(data, 0, bigData, 0, data.length);
        data = bigData;
        helpGC(bigData);
    }

    private void helpGC(E[] array) {
        array = null;
        Arrays.fill(array, null);
    }

    private int hashFunc() {
        return 0;
    }

    @Override
    public void add(E value) {
        if (isFull())
            grow();

        int index = getIndex(value);

    }

    private int getIndex(E value) {
        return 0;
    }

    @Override
    public boolean delete(E value) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void display() {

    }
}

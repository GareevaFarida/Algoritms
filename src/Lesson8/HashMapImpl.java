package Lesson8;

import java.util.LinkedList;

public class HashMapImpl<E, T> implements HashMap<E, T> {
    private int size = 0;
    private LinkedList<Entry<E, T>>[] data;
    private final int MAX_SIZE_OF_MAP;

    private class Entry<E, T> {
        E key;
        T value;

        public Entry(E key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMapImpl(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Invalid capacity of HashMap: " + capacity);
        this.MAX_SIZE_OF_MAP = capacity;
        this.data = new LinkedList[capacity];
    }


    @Override
    public void put(E key, T value) {
        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = new LinkedList<Entry<E, T>>();
        }
        data[index].addFirst(new Entry<>(key, value));
    }

    private int hashFunc(E key) {
        return key.hashCode() % MAX_SIZE_OF_MAP;
    }

    private T get(E key) {
        int index = hashFunc(key);
        if (data[index]==null)
            return null;
        LinkedList<Entry<E,T>> list = data[index];
        while (list.)
        return 0;
    }

    @Override
    public boolean delete(E value) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {

    }
}

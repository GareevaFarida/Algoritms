package Lesson4.LinkedList;

import Lesson3.Queue.Queue;

public class LinkedQueue<E> implements Queue<E> {
    TwoSideLinkedList<E> data;

    public LinkedQueue(TwoSideLinkedList<E> data) {
        this.data = new TwoSideLinkedListImpl<>();
    }
    @Override
    public void insert(E value) {
        data.insertLast(value);
    }

    @Override
    public E remove() {
        return data.deleteFirst();
    }

    @Override
    public E peek() {
        return data.valueOfFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void clear() {
        data.clear();
    }
}

package Lesson4.LinkedList;

import Lesson3.Stack.Stack;

public class LinkedStackImpl<E> implements Stack<E> {
    private LinkedList<E> data;

    public LinkedStackImpl() {
        this.data = new SimpleLinkedListImpl<E>();
    }

    @Override
    public void push(E value) {
        data.insertFirst(value);
    }

    @Override
    public E pop() {
        return data.deleteFirst();
    }

    @Override
    public E peek() {
        return data.valueOfFirst();
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
    public int getSize() {
        return data.getSize();
    }

    @Override
    public void clear() {
        data.clear();
    }
}

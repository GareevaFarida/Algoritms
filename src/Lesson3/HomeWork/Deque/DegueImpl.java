package Lesson3.HomeWork.Deque;

import Lesson3.Queue.QueueImpl;

public class DegueImpl<E> implements Degue<E> {
    QueueImpl<E> queue;
    private int leftIndex;
    private int rightIndex;
    private final int MAX_SIZE;

    public DegueImpl(int size) {
        this.queue = new QueueImpl<E>(size);
        this.MAX_SIZE = size;
    }

    @Override
    public void insertLeft(E value) {
        if (isFull()) throw new RuntimeException("Error: impossible to insert value, deque is full.");
        getQueueIndexes();
        if (leftIndex == 0) {
            leftIndex = MAX_SIZE;
        }
        queue.setTail(leftIndex - 2);
        queue.insert(value);
        queue.setTail(rightIndex);
        queue.setFront(leftIndex - 1);
    }

    private void getQueueIndexes() {
        leftIndex = queue.getFront();
        rightIndex = queue.getTail();
    }

    @Override
    public void insertRight(E value) {
        queue.insert(value);
    }

    @Override
    public E removeLeft() {
        return queue.remove();
    }

    @Override
    public E removeRight() {
        if (isEmpty()) throw new RuntimeException("Error: impossible to remove, deque is empty.");
        getQueueIndexes();
        queue.setFront(rightIndex);
        E value = queue.remove();
        if (rightIndex == 0) {
            rightIndex = MAX_SIZE;
        }
        queue.setTail(rightIndex - 1);
        queue.setFront(leftIndex);
        return value;
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.isFull();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public E peekLeft() {
        return queue.peek();
    }

    @Override
    public E peekRight() {
        getQueueIndexes();
        queue.setFront(rightIndex);
        E value = queue.peek();
        queue.setFront(leftIndex);

        return value;
    }
}

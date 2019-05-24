package Lesson3.Stack;

public class StackImpl<E> implements Stack<E> {
    private E data[];
    private int MAX_SIZE;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int max_size) {
        this.MAX_SIZE = max_size;
        this.data = (E[]) new Object[max_size];
        size = 0;
    }

    @Override
    public void push(E value) {
        if (isFull()) throw new RuntimeException("Stack is full.");
        data[size++] = value;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");
        E temp = data[size - 1];
        data[--size] = null;
        return temp;
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        while (size > 0) {
            pop();
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = size - 1; i > -1; i--) {
            if (i < size - 1) stringBuffer = stringBuffer.append(", ");
            stringBuffer.append(data[i]);
        }
        return stringBuffer.toString();
    }
}

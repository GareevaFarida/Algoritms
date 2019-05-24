package Lesson3.Queue;

public class QueueImpl<E> implements Queue<E> {

    protected E[] data;
    protected int size;
    private static final int FRONT_DEFAULT = 0;
    private static final int TAIL_DEFAULT = -1;
    private int front;
    private int tail;

    public QueueImpl(E[] data) {
        this.data = data;
        this.front = FRONT_DEFAULT;
        this.tail = TAIL_DEFAULT;
        size = data.length;
    }

    @SuppressWarnings("unchecked")
    public QueueImpl(int MAX_SIZE) {
        this((E[]) new Object[MAX_SIZE]);
        size = 0;
    }

    @Override
    public void insert(E value) {
        if(isFull()) throw new RuntimeException("Error: Insertion is impossible - Queue is full.");
        if(tail==data.length-1){
            tail = TAIL_DEFAULT;
        }
        data[++tail] = value;
        size++;
    }

    @Override
    public E peek() {
        return data[front];
    }

    @Override
    public E remove() {
        if (isEmpty()) throw new RuntimeException("Error: Removing is impossible - Queue is empty.");
        if (front==data.length){
            front = FRONT_DEFAULT;
        }
        size--;
        return data[front++];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }

    @Override
    public void clear() {
        while (size > 0) {
            remove();
        }
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getTail() {
        return tail;
    }
}


package Lesson3.Queue;

public class PriorityQueue<E extends Object&Comparable<? super E>> extends QueueImpl<E> {
    public PriorityQueue(int size) {
        super(size);
    }

    @Override
    public void insert(E value) {
        if(isFull()) throw new RuntimeException("Error: Insertion is impossible - Queue is full.");
        if (isEmpty()) {
            data[size++] = value;
        } else {
            int i = 0;
            for (i = size - 1; i > -1; i--) {
                if (value.compareTo(data[i]) > 0) {
                    data[i + 1] = data[i];
                } else break;
            }
            data[i+1] = value;
            size++;
        }
    }
}



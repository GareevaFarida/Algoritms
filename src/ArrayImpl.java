import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    protected int currentSize;
    private static final int INITIAL_CAPACITY = 16;
    protected E[] data;

    public ArrayImpl(int currentSize) {
        this.data = (E[]) new Object[currentSize];
    }

    public ArrayImpl() {
        this(INITIAL_CAPACITY);
    }

    @Override
    public void add(E value) {
        if (data.length == currentSize) {
            grow();
        }
        data[currentSize++] = value;
    }

    private void grow() {
        System.out.println("size after grow() "+data.length * 2);
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1)
            return false;
        for (int i = index; i < currentSize - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--currentSize] = null;
        return true;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= getSize()) throw new IllegalArgumentException("Invalid index of array.");
        return data[index];
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (int i = 0; i < currentSize; i++) {
            if (i > 0) stringBuffer.append(", ");
            stringBuffer.append(data[i]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public void setValueByIndex(E value, int index) {
        data[index] = value;
    }

    @Override
    public void sortBubbles() {
        for (int j = 0; j < currentSize - 1; j++) {
            for (int i = 0; i < currentSize - 1 - j; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    changeValues(i, i + 1);
                }
            }
        }
    }

    @Override
    public void sortSelection() {
        for (int i = 0; i < currentSize; i++) {
            int minIndex = i;
            for (int j = i+1; j < currentSize; j++) {
                if(data[j].compareTo(data[minIndex])<0)
                    minIndex = j;
            }
            if (minIndex!=i){
                changeValues(i, minIndex);
            }
        }
    }

    private void changeValues(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < currentSize; i++) {
            for (int j = i; j > 0; j--) {
                if(data[j].compareTo(data[j-1])<0){
                    changeValues(j,j-1);
                } else break;
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < currentSize; i++) {
            data[i] = null;
        }
        currentSize = 0;
    }
}

package Lesson8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key.equals(entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
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
        } else {
            //ищем существующую запись с таким же ключом
            Entry<E, T> entry = getEntryByKey(data[index], key);
            if (entry == null)
                //запись не найдена, создаем новый элемент в списке
                data[index].addFirst(new Entry<>(key, value));
            else
                //обновляем значение на новое
                entry.value = value;
        }
        size++;
    }

    private int hashFunc(E key) {
        return Math.abs(key.hashCode()) % MAX_SIZE_OF_MAP;
    }

    public T get(E key) {
        int index = hashFunc(key);
        LinkedList<Entry<E, T>> list = data[index];
        if (list == null)
            return null;
        Entry<E, T> entry = getEntryByKey(list, key);
        if (entry != null)
            return entry.value;
        return null;
    }

    private Entry<E, T> getEntryByKey(LinkedList<Entry<E, T>> list, E key) {
        Iterator<Entry<E, T>> iter = list.iterator();
        while (iter.hasNext()) {
            Entry<E, T> currentEntry = iter.next();
            if (currentEntry.key.equals(key)) {
                return currentEntry;
            }
        }
        return null;
    }

    @Override
    public boolean delete(E key) {
        int index = hashFunc(key);
        LinkedList<Entry<E, T>> list = data[index];
        if (list == null)
            return false;
        if (list.remove(new Entry<>(key, null)))
            size--;
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
        if (isEmpty()) {
            System.out.println("Structure is empty.");
            return;
        }
        System.out.println("-------------------------------------------");
        for (int indexOfTable = 0; indexOfTable < data.length; indexOfTable++) {
            LinkedList<Entry<E, T>> list = data[indexOfTable];
            if (list == null
                    || list.isEmpty()) {
                System.out.println(indexOfTable + ": --       --");
                continue;
            }
            Iterator<Entry<E, T>> iter = list.iterator();
            while (iter.hasNext()) {
                Entry<E, T> currentEntry = iter.next();
                System.out.println(indexOfTable + ":  " + currentEntry.key + "     " + currentEntry.value);
            }
        }
        System.out.println("-------------------------------------------");
    }
}

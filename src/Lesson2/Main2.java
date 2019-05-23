package Lesson2;

import java.util.Random;

public class Main2 {
    private static Random rnd = new Random();
    public static final int SIZE_OF_ARRAY = 10_000;

    public static void main(String[] args) {
        Array<Integer> arr = new ArrayImpl<>(SIZE_OF_ARRAY);
        fillArrayRandomValues(arr, SIZE_OF_ARRAY);

        Array<Integer> arrCopy = new ArrayImpl<>(SIZE_OF_ARRAY);

        copyOf(arr, arrCopy);
        testSortBubbles(arrCopy);

        copyOf(arr, arrCopy);
        testSortSelection(arr);

        testSortInsert(arr);
    }

    private static void testSortInsert(Array arr) {
        long t1 = System.nanoTime();
        arr.sortInsert();
        long timeInNanoSec = System.nanoTime()-t1;
        System.out.println("Сортировка вставкой на "+SIZE_OF_ARRAY+" элементах составляет "+timeInNanoSec+" наносекунд.");
    }

    private static void testSortBubbles(Array arr) {
        long t1 = System.nanoTime();
        arr.sortBubbles();
        long timeInNanoSec = System.nanoTime()-t1;
        System.out.println("Сортировка пузырьковая на "+SIZE_OF_ARRAY+" элементах составляет "+timeInNanoSec+" наносекунд.");
    }

    private static void testSortSelection(Array arr) {
        long t1 = System.nanoTime();
        arr.sortSelection();
        long timeInNanoSec = System.nanoTime()-t1;
        System.out.println("Сортировка выбором на "+SIZE_OF_ARRAY+" элементах составляет "+timeInNanoSec+" наносекунд.");
    }

    private static void copyOf(Array<Integer> src, Array<Integer> dst) {
       // dst.clear();
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            dst.add(src.get(i));
        }
    }

    private static void fillArrayRandomValues(Array arr, int size) {
        for (int i = 0; i < size; i++) {
            arr.add((int)(1000*rnd.nextFloat()));
        }
    }
}

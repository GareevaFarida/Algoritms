import java.util.Arrays;
import java.util.Random;

public class Main {
    private static Random rnd = new Random();
    public static final int SIZE_OF_ARRAY = 100;

    public static void main(String[] args) {
        Array<Float> arr = new ArrayImpl<>(SIZE_OF_ARRAY);
        fillArrayRandomValues(arr, SIZE_OF_ARRAY);

        Array<Float> arrCopy = new ArrayImpl<>(SIZE_OF_ARRAY);

//        System.out.println(arr.toString());
//        System.out.println(arrCopy.toString());

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

    private static void copyOf(Array<Float> arr, Array<Float> arrCopy) {
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            arrCopy.add(arr.get(i));
        }
    }

    private static void fillArrayRandomValues(Array arr, int size) {
        for (int i = 0; i < size; i++) {
            arr.add(rnd.nextFloat());
        }
    }
}

package Lesson3.HomeWork;

import Lesson3.HomeWork.Deque.Degue;
import Lesson3.HomeWork.Deque.DegueImpl;
import Lesson3.HomeWork.StringConverter.StringConverter;
import Lesson3.HomeWork.StringConverter.StringReader;

public class HomeWork {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        System.out.println("Конвертация строк.");
//        //  while (true) {
        String str = new StringReader().getString();
        StringConverter stringConverter = new StringConverter(str);
        System.out.println(stringConverter.convert());
//        //}
        System.out.println("-----------------------------------------");
        Degue deq = new DegueImpl(10);
        deq.insertRight(3);
        deq.insertRight(4);
        deq.insertRight(5);
        deq.insertRight(6);
        deq.insertLeft(2);
        deq.insertLeft(1);
        deq.insertLeft(0);
        deq.insertRight(7);
        deq.insertLeft(-1);
        System.out.println("Значение слева = "+deq.peekLeft());
        System.out.println("Значение справа = "+deq.peekRight());

        System.out.println("Удаление слева:");
        while (deq.getSize() > 0) {
            System.out.println(deq.removeLeft());
        }

        deq.insertRight(3);
        deq.insertRight(4);
        deq.insertRight(5);
        deq.insertRight(6);
        deq.insertLeft(2);
        deq.insertLeft(1);
        deq.insertLeft(0);
        deq.insertRight(7);
        deq.insertLeft(-1);

        System.out.println("Удаление справа:");
        while (deq.getSize() > 0) {
            System.out.println(deq.removeRight());
        }
    }
}

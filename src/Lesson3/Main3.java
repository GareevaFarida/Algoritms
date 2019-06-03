package Lesson3;

import Lesson3.HomeWork.StringConverter.StringReader;
import Lesson3.Queue.Queue;
import Lesson3.Queue.QueueImpl;
import Lesson3.Stack.Bracket;

public class Main3 {
    public static void main(String[] args) {

        System.out.println("Проверка строки на корректность использования открывающих и закрывающих скобок.");
        Bracket br = new Bracket(new StringReader().getString());
        br.check();

        System.out.println("----------------------------------------");
        Queue<Integer> q = new QueueImpl<Integer>(new Integer[]{1, 2, 3, 4, 5});
        for (int i = 0; i < 5; i++) {

            System.out.println("Вершина очереди " + q.remove());
        }
        System.out.println("Get size before clearing " + q.getSize());
        q.clear();
        System.out.println("Get size after clearing " + q.getSize());
        for (int i = 0; i < 4; i++) {
            q.insert(i);
        }
        System.out.println("Size after insertion " + q.getSize());
        System.out.println("----------------------------------------");

//        PriorityQueue<Integer> pq = new PriorityQueue<>(9);
//        pq.insert(30);
//        pq.insert(20);
//        pq.insert(70);
//        pq.insert(60);
//        pq.insert(10);
//        pq.insert(40);
//        pq.insert(80);
//        pq.insert(30);
//        System.out.println("Size of priority queue = " + pq.getSize());
//        int size = pq.getSize();
//        for (int i = 0; i < size; i++) {
//            System.out.println(pq.remove());
//            System.out.println("Size of priority queue = " + pq.getSize());
//        }
    }
}

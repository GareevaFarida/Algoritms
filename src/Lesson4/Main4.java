package Lesson4;

import Lesson3.Stack.Stack;
import Lesson4.LinkedList.*;

import java.util.Iterator;

public class Main4 {
    public static void main(String[] args) {
        testLinkedList();
        testLinkedStack();
        testTwoSideLinkedList();
    }

    private static void testTwoSideLinkedList() {
        TwoSideLinkedList<Integer> list = new TwoSideLinkedListImpl<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertLast(0);
        System.out.println("Size of list = "+list.getSize());
        list.display();
        System.out.println("Delete top = "+list.deleteFirst());
        System.out.println("Delete value 0 = "+list.delete(0));
        list.display();
        list.insertAfterValue(100,4);
        System.out.println("Inserted value 100 after value 4");
        list.display();
        list.insertAfterValue(200,1);
        System.out.println("Inserted value 200 after value 1");
        list.display();
        list.insertLast(300);
        System.out.println("Inserted last element 300");
        list.display();
    }

    private static void testLinkedStack() {
        Stack<Integer> stack = new LinkedStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Top of stack = "+stack.peek());
        System.out.println("Size of stack = " + stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Stack is empty = "+stack.isEmpty());
    }

    private static void testLinkedList() {
        LinkedList<Integer> arr = new SimpleLinkedListImpl<>();
        arr.insertFirst(1);
        arr.insertFirst(2);
        arr.insertFirst(3);
        arr.insertFirst(4);
        arr.insertFirst(5);
        arr.insertFirst(6);
        System.out.println("Size of LinkedList = " + arr.getSize());
        arr.display();
        arr.deleteFirst();
        arr.delete(4);
        arr.delete(1);
        System.out.println("After removing top & 4 & 1");
        arr.display();
        System.out.println("Value of first = " + arr.valueOfFirst());
        System.out.println("Contains 1 = " + arr.contains(1));
        arr.insertAfterValue(4, 5);
        System.out.println("After insertion 4 after 5");
        arr.display();

        arr.insertAfterValue(7, 5);
        arr.insertAfterValue(7, 4);
        arr.insertAfterValue(7, 2);
        arr.insertAfterValue(7, 1);
        arr.insertFirst(7);
        System.out.println("After insertion 7");
        arr.display();
        System.out.println("Removed all 7. Count of deleted values = " + arr.deleteAllEntriesOfValue(7));
        System.out.println("after removing 7");
        arr.display();
        arr.clear();
        System.out.println("After clearing first element = " + arr.valueOfFirst() + ", size of array = " + arr.getSize());
        System.out.println("Oтображение пустого массива:");
        arr.display();
        arr.insertFirst(1);
        arr.deleteFirst();
        System.out.println("Value of first element = "+(arr.valueOfFirst()));
    }
}

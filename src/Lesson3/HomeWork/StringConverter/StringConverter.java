package Lesson3.HomeWork.StringConverter;

import Lesson3.Stack.StackImpl;

public class StringConverter {

    private String str;

    public StringConverter(String str) {
        this.str = str;
    }

    public String convert() {
        char[] arr = str.toCharArray();
        StackImpl<Character> stack = new StackImpl<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (stack.getSize() > 0) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}

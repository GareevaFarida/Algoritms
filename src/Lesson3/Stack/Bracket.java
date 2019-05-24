package Lesson3.Stack;

public class Bracket {
    String str;

    public Bracket(String str) {
        this.str = str;
    }

    public void check() {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new StackImpl<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            switch (currentChar) {
                case '(':
                case '{':
                case '[':
                case '<': {
                    stack.push(currentChar);
                    break;
                }
                case ')':
                case '}':
                case ']':
                case '>': {
                    if (stack.isEmpty()) {
                        System.out.println("Error: " + currentChar + " in " + i + " position.");
                        return;
                    }
                    char lastBracket = stack.peek();
                    if (currentChar == ')' && lastBracket == '('
                            || currentChar == '}' && lastBracket == '{'
                            || currentChar == ']' && lastBracket == '['
                            || currentChar == '>' && lastBracket == '<') {
                        stack.pop();
                        break;
                    } else {
                        System.out.println("Error: " + currentChar + " in " + i + " position.");
                        break;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: brackets " + stack.toString() + " have not closing pair.");
        }
    }
}

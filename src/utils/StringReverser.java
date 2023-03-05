package utils;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {

        StringBuffer reverseWord = new StringBuffer();

        var stack = new Stack<Character>();

        for (char ch : input.toCharArray()
        ) {
            stack.push(ch);
        }

        while (!stack.empty()) {
            reverseWord.append(stack.pop());
        }

        return reverseWord.toString();
    }

}

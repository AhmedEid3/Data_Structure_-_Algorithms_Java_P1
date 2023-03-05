package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> openBrackets = Arrays.asList('(', '[', '<');
    private final List<Character> closeBrackets = Arrays.asList(')', ']', '>');

    public boolean isBalanceExpression(String input) {
        var stack = new Stack<Character>();

        for (char ch : input.toCharArray()
        ) {
            if (isBracketOpen(ch)) {
                stack.push(ch);
            } else if (isBracketClose(ch)) {
                if (stack.isEmpty()) return false;

                char lastChar = stack.pop();
                if (!bracketsMatch(lastChar, ch)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean bracketsMatch(char openBracket, char closedBracket) {
        return openBrackets.indexOf(openBracket) ==
                closeBrackets.indexOf(closedBracket);

    }

    private boolean isBracketOpen(char bracket) {
        return openBrackets.contains(bracket);
    }

    private boolean isBracketClose(char bracket) {
        return closeBrackets.contains(bracket);
    }
}

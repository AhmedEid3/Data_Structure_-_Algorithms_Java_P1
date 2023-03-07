package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char finderFirstNoneRepeatingChar(String str) {

        Map<Character, Integer> mapInput = new HashMap<>();

        char[] chars = str.toCharArray();

        for (char ch : chars
        ) {
            int count = mapInput.containsKey(ch) ? mapInput.get(ch) + 1 : 1;
            mapInput.put(ch, count);
        }

        for (char ch : chars
        ) {
            if (mapInput.get(ch) == 1) return ch;
        }

        return Character.MAX_VALUE;
    }

    public char finderFirstRepeatedChar(String str) {
        Set<Character> setInput = new HashSet<>();

        char[] chars = str.toCharArray();

        for (char ch : chars
        ) {
            if (setInput.contains(ch)) return ch;

            setInput.add(ch);
        }

        return Character.MAX_VALUE;
    }


}

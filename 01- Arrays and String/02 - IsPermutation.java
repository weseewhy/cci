/*
Check Permutation:
Given two strings, write a method to decide if one is a permutation of the other

Notes:
Comparison is case sensitive
Whitespace is significant
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer cnt = cntMap.get(c);
            if (cnt == null || cnt == 0) {
                return false;
            }

            cntMap.put(c, cnt - 1);
        }

        return true;
    }

    /*
    Other option is to sort the string and compare them
    */
}

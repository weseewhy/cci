/*
Permutations with Duplicates:
Write a method to compute all permutations of a string whose characters are not necessarily unique.
The list of permutations should not have duplicates.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> permute(String s) {
        Map<Character, Integer> charCnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        }

        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        permute(charCnt, sb, s.length(), out);
        return out;
    }

    private void permute(Map<Character, Integer> charCnt, StringBuilder sb, int maxLength, List<String> out) {
        if (sb.length() == maxLength) {
            out.add(sb.toString());
            return;
        }

        for (char c : charCnt.keySet()) {
            if (charCnt.get(c) > 0) {
                sb.append(c);
                charCnt.put(c, charCnt.get(c) - 1);

                permute(charCnt, sb, maxLength, out);

                // backtrack
                sb.deleteCharAt(sb.length() - 1);
                charCnt.put(c, charCnt.get(c) + 1);
            }
        }
    }
}

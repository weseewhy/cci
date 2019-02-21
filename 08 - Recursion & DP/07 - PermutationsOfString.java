/*
Permutations without Duplicates:
Write a method to compute all permutations of a string of unique characters.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> permute(String s) {
        List<String> out = new ArrayList<>();
        permute(s.toCharArray(), 0, s.length() - 1, out);
        return out;
    }

    private void permute(char[] input, int start, int end, List<String> out) {
        if (start == end) {
            out.add(new String(input));
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(input, start, i);
            permute(input, start + 1, end, out);
            swap(input, start, i);
        }
    }

    private void swap(char[] input, int i, int j) {
        if (i != j) {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }
}

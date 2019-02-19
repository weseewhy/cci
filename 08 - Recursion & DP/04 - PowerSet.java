/*
Power Set:
Write a method to return all subsets of a set.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> powerSet(List<Integer> input) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        traverse(input, prefix, out);
        return out;
    }

    private void traverse(List<Integer> input, List<Integer> prefix, List<List<Integer>> out) {
        if (input.size() == 0) {
            out.add(new ArrayList<>(prefix));
            return;
        }

        int cur = input.remove(0);

        // without including first number
        traverse(input, prefix, out);

        // including first number
        prefix.add(cur);
        traverse(input, prefix, out);
        prefix.remove(prefix.size() - 1);
        input.add(0, cur);
    }

    /* ================= Bit flags ================= */

    public List<List<Integer>> powerSet2(List<Integer> input) {
        List<List<Integer>> out = new ArrayList<>();
        int max = 1 << input.size();

        for (int i = 0; i < max; i++) {
            out.add(getSubSet(input, i));
        }

        return out;
    }

    private List<Integer> getSubSet(List<Integer> input, int flags) {
        List<Integer> subset = new ArrayList<>();
        int checker = 1 << input.size() - 1;
        for (Integer digit : input) {
            boolean include = (flags & checker) != 0;
            if (include) {
                subset.add(digit);
            }

            checker >>= 1;
        }

        return subset;
    }
}

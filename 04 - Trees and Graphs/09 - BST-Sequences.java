/*
BST Sequences:
A binary search tree was created by traversing through an array from left to right and inserting each element.
Given a binary search tree with distinct elements, return all possible arrays that could have led to this tree.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allSequences(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            out.add(new ArrayList<>());
            return out;
        }

        List<Integer> prefix = new ArrayList<>();
        prefix.add(root.val);

        List<List<Integer>> leftSequences = allSequences(root.left);
        List<List<Integer>> rightSequences = allSequences(root.right);

        for (List<Integer> left : leftSequences) {
            for (List<Integer> right : rightSequences) {
                weave(left, right, out, prefix);
            }
        }

        return out;
    }

    private void weave(List<Integer> l1, List<Integer> l2, List<List<Integer>> results, List<Integer> prefix) {
        if (l1.isEmpty() || l2.isEmpty()) {
            List<Integer> out = new ArrayList<>(prefix);
            out.addAll(l1);
            out.addAll(l2);
            results.add(out);
            return;
        }

        int firstElement = l1.remove(0);
        prefix.add(firstElement);
        weave(l1, l2, results, prefix);
        l1.add(0, firstElement);
        prefix.remove(prefix.size() - 1);

        firstElement = l2.remove(0);
        prefix.add(firstElement);
        weave(l1, l2, results, prefix);
        l2.add(0, firstElement);
        prefix.remove(prefix.size() - 1);
    }
}

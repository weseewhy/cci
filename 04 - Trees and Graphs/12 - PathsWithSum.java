/*
Paths with Sum:
You are given a binary tree in which each node contains an integer value (which might be positive or negative).
Design an algorithm to count the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf,
but it must go downwards (traveling only from parent nodes to child nodes).
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        return pathSumStartingFrom(node, sum)   // Path that starts from current node and reaching target sum
                + pathSum(node.left, sum)       // Path that exists in left sub-tree
                + pathSum(node.right, sum);     // Path that exists in right sub-tree
    }

    private int pathSumStartingFrom(TreeNode node, int remainingSum) {
        if (node == null) {
            return 0;
        }

        int cnt = 0;
        remainingSum -= node.val;
        if (remainingSum == 0) {
            cnt++;
        }

        // Have to loop left left and right sub-trees even when the
        // remaining sum is zero because tree has negative values
        cnt += pathSumStartingFrom(node.left, remainingSum);
        cnt += pathSumStartingFrom(node.right, remainingSum);

        return cnt;
    }

    /* ================== OPTIMIZED ================== */

    public int pathSum_Optimized(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        return pathSum_Optimized(root, targetSum, 0, prefixSumMap);
    }

    private int pathSum_Optimized(TreeNode node, int targetSum, int runningSum, Map<Integer, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        int cnt = 0;
        int currentPrefixSum = runningSum + node.val;
        int desiredPrefixSum = currentPrefixSum - targetSum;
        if (prefixSumMap.containsKey(desiredPrefixSum)) {
            cnt += prefixSumMap.get(desiredPrefixSum);
        }

        prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);

        cnt += pathSum_Optimized(node.left, targetSum, currentPrefixSum, prefixSumMap);
        cnt += pathSum_Optimized(node.right, targetSum, currentPrefixSum, prefixSumMap);

        // Backtrack
        prefixSumMap.put(currentPrefixSum, prefixSumMap.get(currentPrefixSum) - 1);
        return cnt;
    }
}

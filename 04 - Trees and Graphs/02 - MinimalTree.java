/*
Minimal Tree: 
Given a sorted (increasing order) array with unique integer elements, 
write an algorithm to create a binary search tree with minimal height.
*/
class Solution {
    public TreeNode createMinimalBST(int[] nums) {
        return createMinimalBST(nums, 0, nums.length - 1);
    }

    private TreeNode createMinimalBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createMinimalBST(nums, start, mid - 1);
        root.right = createMinimalBST(nums, mid + 1, end);
        return root;
    }
}

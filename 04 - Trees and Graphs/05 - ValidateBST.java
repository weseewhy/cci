/*
Validate 8ST: 
Implement a function to check ifa binary tree is a binary search tree.
*/

class Solution {
    public boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        } else if (node.val < min || node.val > max) {
            return false;
        } else {
            return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
        }
    }
}

/*
Successor:
Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
You may assume that each node has a link to its parent.
*/
class Solution {
    TreeNode successor(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode lastLeft = null;
        TreeNode node = root;
        while (node != null && node.val != val) {
            if (val < node.val) {
                lastLeft = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node == null) {
            throw new RuntimeException("Invalid val");
        }

        if (node.right != null) {
            TreeNode cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        return lastLeft;
    }
}

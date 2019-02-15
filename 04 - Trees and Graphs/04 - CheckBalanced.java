/*
Check Balanced: 
Implement a function to check if a binary tree is balanced. 
For the purposes of this question, a balanced tree is defined to be a tree 
such that the heights of the two subtrees of any node never differ by more than one.
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new Height());
    }

    private boolean isBalanced(TreeNode node, Height height) {
        if (node == null) {
            return true;
        }

        Height lHeight = new Height();
        boolean leftBalanced = isBalanced(node.left, lHeight);
        if (!leftBalanced) {
            return false;
        }

        Height rHeight = new Height();
        boolean rightBalanced = isBalanced(node.right, rHeight);
        if (!rightBalanced) {
            return false;
        }

        if (Math.abs(lHeight.val - rHeight.val) > 1) {
            return false;
        }

        height.val = Math.max(lHeight.val, rHeight.val) + 1;
        return true;
    }
}

class Height {
    int val = 0;
}

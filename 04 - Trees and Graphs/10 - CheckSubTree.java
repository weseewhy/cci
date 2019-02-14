/*
Check Subtree:
T1 and T2 are two very large binary trees, with T1 much bigger than T2.
Create an algorithm to determine if T2 is a subtree of T1.

A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. 
That is, if you cut off the tree at node n, the two trees would be identical.
*/

class Solution {
    public boolean containsTree(TreeNode n1, TreeNode n2) {
        if (n2 == null) {
            return true;
        } else if (n1 == null) {
            return false;
        }

        return isSame(n1, n2) || containsTree(n1.left, n2) || containsTree(n1.right, n2);
    }

    private boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        }

        return n1.val == n2.val
                && isSame(n1.left, n2.left)
                && isSame(n1.right, n2.right);
    }
}

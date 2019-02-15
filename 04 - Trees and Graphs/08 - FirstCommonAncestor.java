/*
First Common Ancestor: 
Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
Avoid storing additional nodes in a data structure. 

NOTE: This is not necessarily a binary search tree.
*/
class Solution {
    public TreeNode findLCA(TreeNode node, int i, int j) {
        return search(node, i, j);
    }

    // This solution doesn't handle the case when one of the node is not present in tree
    private TreeNode search(TreeNode node, int i, int j) {
        if (node == null) {
            return null;
        } else if (node.val == i || node.val == j) {
            return node;
        }

        TreeNode leftSearch = search(node.left, i, j);
        TreeNode rightSearch = search(node.right, i, j);

        if (leftSearch != null && rightSearch != null) {
            return node;
        } else {
            return leftSearch != null ? leftSearch : rightSearch;
        }
    }
}

/*
List of Depths: 
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
(e.g., if you have a tree with depth D, you'll have D linked lists).
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> listsOfDepths(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nodesInCurLevel = 1;
        int nodesInNextLevel = 0;
        List<Integer> nodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            nodes.add(cur.val);

            if (cur.left != null) {
                queue.offer(cur.left);
                nodesInNextLevel++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nodesInNextLevel++;
            }

            nodesInCurLevel--;
            if (nodesInCurLevel == 0) {
                out.add(new ArrayList<>(nodes));
                nodes.clear();
                nodesInCurLevel = nodesInNextLevel;
                nodesInNextLevel = 0;
            }
        }

        return out;
    }
}

/*
Random Node:
You are implementing a binary tree class from scratch which, in addition to insert, find, and delete,
has a method getRandomNode() which returns a random node from the tree.
All nodes should be equally likely to be chosen.
Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.
*/

import java.util.Random;

class Tree {
    TreeNode root = null;

    int size() {
        return this.root != null ? this.root.size : 0;
    }

    // Idea is to pick a random number 'i' less than size of tree and 
    // return the i-th val in inorder traversal
    // Instead of calculating size all the time, store the size of tree at each node
    TreeNode getRandomNode() {
        if (this.root == null) {
            return null;
        }

        int randomNodeIndex = new Random().nextInt(size());
        return this.root.getIthNode(randomNodeIndex);
    }

    void insert(int val) {
        if (this.root == null) {
            this.root = new TreeNode(val);
        } else {
            this.root.insert(val);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int size;

    TreeNode(int val) {
        this.val = val;
        this.size = 1;
    }

    public void insert(int val) {
        if (val <= this.val) {
            if (this.left == null) {
                this.left = new TreeNode(val);
            } else {
                this.left.insert(val);
            }
        } else {
            if (this.right == null) {
                this.right = new TreeNode(val);
            } else {
                this.right.insert(val);
            }
        }

        this.size++;
    }

    TreeNode getIthNode(int i) {
        int leftSize = this.left != null ? this.left.size : 0;
        if (i < leftSize) {
            return this.left.getIthNode(i);
        } else if (i > leftSize) {
            return this.right.getIthNode(i - (leftSize + 1));
        } else {
            return this;
        }
    }

    TreeNode find(int val) {
        if (this.val == val) {
            return this;
        } else if (val < this.val) {
            return this.left != null ? this.left.find(val) : null;
        } else {
            return this.right != null ? this.right.find(val) : null;
        }
    }
}

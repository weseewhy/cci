/*
Delete Middle Node:
Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
(i.e., any node but the first and last node, not necessarily the exact middle)

EXAMPLE
Input: the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f
*/

class Solution {
    boolean delete(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        node.val = node.next.val;
        node.next = node.next.next;
        return true;
    }
}

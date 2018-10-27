/*
Return Kth to Last:
Implement an algorithm to find the kth to last element of a singly linked list.
*/

class Solution {
    ListNode kthFromLast(ListNode node, int k) {
        if (k < 1) {
            return null;
        }

        ListNode p1 = node;
        for (int i = 1; i <= k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        ListNode p2 = node;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}

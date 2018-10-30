/*
Intersection:
Given two (singly) linked lists, determine if the two lists intersect.
Return the intersecting node. Note that the intersection is defined based on reference, not value.
That is, if the kth node of the first linked list is the exact same node (by reference)
as the jth node of the second linked list, then they are intersecting.
*/

class Solution {
    ListNode intersectingNode(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return null;
        }

        // If tail nodes are not same, then there is no intersection
        Tail t1 = getTailNode(n1);
        Tail t2 = getTailNode(n2);
        if (t1.node != t2.node) {
            return null;
        }

        if (t1.length > t2.length) {
            n1 = moveN(n1, t1.length - t2.length);
        } else if (t2.length > t1.length) {
            n2 = moveN(n2, t2.length - t1.length);
        }

        while (n1 != null && n2 != null) {
            if (n1 == n2) {
                return n1;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        return null;
    }

    class Tail {
        ListNode node;
        int length;

        Tail(ListNode node, int length) {
            this.node = node;
            this.length = length;
        }
    }

    private ListNode moveN(ListNode head, int n) {
        while (n > 0) {
            head = head.next;
            n--;
        }
        return head;
    }

    private Tail getTailNode(ListNode h) {
        int len = 1;
        while (h.next != null) {
            len++;
            h = h.next;
        }

        return new Tail(h, len);
    }
}

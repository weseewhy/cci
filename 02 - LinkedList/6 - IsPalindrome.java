/*
Palindrome:
Implement a function to check if a linked list is a palindrome
*/

class Solution {
    boolean palindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;

            if (p2.next != null) {
                p2 = p2.next;
            }
        }

        p2 = reverse(p1.next);
        p1 = head;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}

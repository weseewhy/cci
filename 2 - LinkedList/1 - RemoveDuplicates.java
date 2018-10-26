/*
Remove Duplicates:
Write code to remove duplicates from an unsorted linked list.

FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    void removeDuplicates(ListNode head) {
        if (head == null) {
            return;
        }

        Set<Integer> nums = new HashSet<>();
        nums.add(head.val);
        ListNode prev = head;
        ListNode cur = prev.next;

        while (cur != null) {
            if (!nums.contains(cur.val)) {
                prev.next = cur;
                prev = cur;
                nums.add(cur.val);
            }
            cur = cur.next;
        }

        prev.next = null;
    }

    // Without extra space
    void removeDuplicates2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode cur = head;
        while (cur != null) {
            ListNode prev = cur;
            ListNode checker = cur.next;
            while (checker != null) {
                if (checker.val == cur.val) {
                    prev.next = checker.next;
                } else {
                    prev = prev.next;
                }
                checker = checker.next;
            }
            cur = cur.next;
        }
    }
}

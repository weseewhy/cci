/*
Sum Lists: 
You have two numbers represented by a linked list, where each node contains a single digit. 
The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.

EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .That is,617 + 295. 
Output:2 -> 1 -> 9. That is, 912.

FOLLOW UP
What if the digits are stored in forward order. 
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. 
Output:9 -> 1 -> 2.That is, 912.
*/

class Solution {
    ListNode sumLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        int sum = 0;
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            if (head == null) {
                head = new ListNode(sum);
                tail = head;
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode rem = l1 != null ? l1 : l2;
        while (rem != null) {
            sum = rem.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
            rem = rem.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

    /******************** Recursive ************************/

    ListNode sumLists_Recursive(ListNode l1, ListNode l2) {
        return sumLists_Recursive(l1, l2, 0);
    }

    private ListNode sumLists_Recursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                return new ListNode(carry);
            } else {
                return null;
            }
        }

        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }

        carry = sum / 10;
        sum = sum % 10;

        ListNode node = new ListNode(sum);
        node.next = sumLists_Recursive(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return node;
    }

    /******************** LinkedList with correct order ************************/

    ListNode sumLists_CorrectOrder(ListNode l1, ListNode l2) {
        int l1Length = lengthOfList(l1);
        int l2Length = lengthOfList(l2);
        if (l1Length < l2Length) {
            l1 = padZeroes(l1, l2Length - l1Length);
        } else if (l2Length < l1Length) {
            l2 = padZeroes(l2, l1Length - l2Length);
        }

        PartitionSum sum = partitionSumHelper(l1, l2);
        ListNode head = sum.node;
        if (sum.carry != 0) {
            ListNode newHead = new ListNode(sum.carry);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    private int lengthOfList(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode padZeroes(ListNode head, int numOfZeroesToAdd) {
        for (int i = 0; i < numOfZeroesToAdd; i++) {
            ListNode zero = new ListNode(0);
            zero.next = head;
            head = zero;
        }

        return head;
    }

    private PartitionSum partitionSumHelper(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        PartitionSum partitionSum = partitionSumHelper(l1.next, l2.next);
        int sum = l1.val + l2.val + (partitionSum != null ? partitionSum.carry : 0);
        int carry = sum / 10;
        sum = sum % 10;

        ListNode node = new ListNode(sum);
        node.next = partitionSum != null ? partitionSum.node : null;

        return new PartitionSum(node, carry);
    }

    class PartitionSum {
        int carry;
        ListNode node;

        PartitionSum(ListNode node, int carry) {
            this.node = node;
            this.carry = carry;
        }
    }
}

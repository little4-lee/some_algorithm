package linkedlist;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        long num1 = 0;
        int count1 = 0;
        ListNode p1 = l1;
        while (p1 != null) {
            num1 = (long)Math.pow(10, count1++) * p1.val + num1;
            p1 = p1.next;
        }

        long num2 = 0;
        int count2 = 0;
        ListNode p2 = l2;
        while (p2 != null) {
            num2 = (long)Math.pow(10, count2++) * p2.val + num2;
            p2 = p2.next;
        }

        long sum = num1 + num2;
        if (sum == 0) return new ListNode(0);

        ListNode soldier = new ListNode(0);
        ListNode p = soldier;
        ListNode temp = null;
        while (sum > 0) {
            p.next = new ListNode((int)(sum % 10));
            p = p.next;
            sum = sum / 10;
        }
        return soldier.next;
    }

    public static void main (String[] args) {
//        ListNode list1 = NodeUtils.arrayToList(2,4,3);
//        ListNode list2 = NodeUtils.arrayToList(5,6,4);
        ListNode list1 = NodeUtils.arrayToList(9);
        ListNode list2 = NodeUtils.arrayToList(1,9,9,9,9,9,9,9,9,9);
        NodeUtils.printList(new L2().addTwoNumbers(list1, list2));
    }
}

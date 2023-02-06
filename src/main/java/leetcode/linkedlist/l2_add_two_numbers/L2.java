package leetcode.linkedlist.l2_add_two_numbers;

import common.ListNode;

import static common.ListUtilsKt.*;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        ListNode p1 = l1;
        ListNode p2 = l2;

        boolean up = false;

        while (p1 != null && p2 != null) {
            int val = p1.value + p2.value + (up ? 1 : 0);

            //进位
            if (val >= 10) {
                up = true;
                val %= 10;
            } else {
                up = false;
            }

            ListNode node = new ListNode(val);

            p.next = node;
            p = node;

            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;

        //没有进位
        if (!up) return soldier.next;

        //存在进位
        ListNode pre = p;
        ListNode pEnd = p.next;
        while (true) {
            if (pEnd == null) {
                //(增加了一位)总位数+1
                pre.next = new ListNode(1);
                break;
            }

            if (pEnd.value != 9) {
                pEnd.value += 1;
                break;
            }

            //pEnd.val == 9
            pEnd.value = 0;
            pre = pEnd;
            pEnd = pEnd.next;
        }

        return soldier.next;
    }

    public static void main(String[] args) {

        L2 l = new L2();
        printListInLine(l.addTwoNumbers(arrayToList(2, 4, 3), arrayToList(5, 6, 4)));
        System.out.println();

        printListInLine(l.addTwoNumbers(arrayToList(9), arrayToList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)));
        System.out.println();

        printListInLine(l.addTwoNumbers(arrayToList(9), arrayToList(1, 9, 9)));
        System.out.println();

        printListInLine(l.addTwoNumbers(arrayToList(5), arrayToList(5)));
        System.out.println();

        printListInLine(l.addTwoNumbers(arrayToList(0), arrayToList(0)));
        System.out.println();

        printListInLine(l.addTwoNumbers(arrayToList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1), arrayToList(5, 6, 4)));
    }
}

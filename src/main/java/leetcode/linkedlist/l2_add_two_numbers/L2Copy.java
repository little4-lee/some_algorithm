package leetcode.linkedlist.l2_add_two_numbers;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printListInLine;

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
public class L2Copy {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solder = new ListNode(0);
        ListNode p = solder;

        boolean up = false;
        ListNode p1 = l1;
        ListNode p2 = l2;
        //add process
        while (p1 != null && p2 != null) {

            int value = p1.value + p2.value + (up ? 1 : 0);
            if (value >= 10) {
                up = true;
                value %= 10;
            } else {
                up = false;
            }
            ListNode node = new ListNode(value);

            p.next = node;
            p = node;

            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null) p.next = p2;
        if (p2 == null) p.next = p1;

        //no up
        if (!up) return solder.next;

        //up process
        ListNode pre = p;
        ListNode next = p.next;

        while (true) {
            if (next == null) {
                pre.next = new ListNode(1);
                break;
            }

            if (next.value < 9) {
                next.value += 1;
                break;
            }

            //next.value == 9
            next.value = 0;
            pre = next;
            next = next.next;
        }

        return solder.next;
    }


    public static void test() {
        L2Copy l = new L2Copy();
        printListInLine(l.addTwoNumbers(null, null));
        System.out.println();

        printListInLine(l.addTwoNumbers(null, arrayToList(5, 6, 4)));
        System.out.println();

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

    public static void main(String[] args) {
        test();
    }
}

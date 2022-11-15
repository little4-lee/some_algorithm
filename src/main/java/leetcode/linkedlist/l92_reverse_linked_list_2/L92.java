package leetcode.linkedlist.l92_reverse_linked_list_2;

import common.ListNode;

/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right
 * where left <= right, reverse the nodes of the list from position left to position right,
 * and return the reversed list.
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * Follow up: Could you do it in one pass?
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class L92 {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;

        int index = 1;
        //哨兵节点，next指向head，简化逻辑
        ListNode soldier = new ListNode(8080);

        ListNode p = head;
        //reverse 的起点前一个节点
        ListNode preStart = null;
        if (m == 1) preStart = soldier;
        //reverse 的起点
        ListNode start = null;

        soldier.next = head;

        while (p != null && index <= n) {
            ListNode pNext = p.next;
            if (index == m - 1) {
                preStart = p;
            }

            if (index >= m) {

                if (index == m) {
                    start = p;
                }

                p.next = preStart.next;
                preStart.next = p;
            }

            index++;
            p = pNext;
        }

        start.next = p;

        return soldier.next;
    }
}

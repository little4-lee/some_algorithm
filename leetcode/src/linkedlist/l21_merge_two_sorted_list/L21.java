package linkedlist.l21_merge_two_sorted_list;

import linkedlist.ListNode;
import linkedlist.NodeUtils;

/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 *
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class L21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode soldier = new ListNode(0);
        ListNode p = soldier;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null&& p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;

        return soldier.next;
    }

    public static void main (String[] args) {

        ListNode l1 = NodeUtils.arrayToList(1, 2, 3, 4, 10, 100);
        ListNode l2 = NodeUtils.arrayToList(2, 2, 2, 4, 4, 101, 101, 101, 101);
        NodeUtils.printList(new L21().mergeTwoLists(l1, l2));
    }
}

package linkedlist.l92_reverse_linked_list_2;

import java.util.List;

import linkedlist.ListNode;
import linkedlist.NodeUtils;

/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right
 * where left <= right, reverse the nodes of the list from position left to position right,
 * and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 *  Example 2:
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
public class L92Copy {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode soldier = new ListNode(0);
        soldier.next = head;

        ListNode p = soldier;
        int count = 0;
        ListNode preStart = null;
        ListNode start = null;

        while (true) {
            if (count < m) {
                if (count == m - 1) {
                    preStart = p;
                    start = p.next;
                }

                count++;
                p = p.next;
                continue;
            }

            if (count <= n) {
                //m ~ n
                ListNode pNext = p.next;
                p.next = preStart.next;
                preStart.next = p;
                p = pNext;
                count++;
                continue;
            }

            //> n
            start.next = p;
            break;
        }

        return soldier.next;
    }

    public static void main (String[] args) {
//        ListNode list = NodeUtils.arrayToList(1);
        ListNode list = NodeUtils.arrayToList(1, 2);
        NodeUtils.printList(new L92Copy().reverseBetween(list, 2, 2));

//        ListNode list = NodeUtils.arrayToList(1, 2, 3, 4, 5, 6, 7);
//        NodeUtils.printList(new L92Copy().reverseBetween(list, 1, 7));
//        NodeUtils.printList(new L92Copy().reverseBetween(list, 5, 7));
//        NodeUtils.printList(new L92Copy().reverseBetween(list, 1, 5));
//        NodeUtils.printList(new L92Copy().reverseBetween(list, 2, 5));
    }
}

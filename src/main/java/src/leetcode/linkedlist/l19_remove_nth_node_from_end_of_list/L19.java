package leetcode.linkedlist.l19_remove_nth_node_from_end_of_list;

import leetcode.linkedlist.ListNode;
import leetcode.linkedlist.NodeUtils;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 * Follow up: Could you do this in one pass?
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class L19 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (head == null) return null;

        ListNode soldier = new ListNode(0);
        soldier.next = head;
        ListNode slow = head;
        ListNode fast = head;

        int index = 1;
        while (index < n && fast != null) {
            index++;
            fast = fast.next;
        }

        if (fast == null) {
            //list size < n
            return head;
        }

        ListNode slowPre = soldier;
        while (fast.next != null) {
            fast = fast.next;
            slowPre = slow;
            slow = slow.next;
        }

        slowPre.next = slow.next;
        slow.next = null;

        return soldier.next;
    }

    public static void main (String[] args) {
        L19 l = new L19();
//        ListNode list = NodeUtils.arrayToList(1, 2, 3, 4, 5);
        ListNode list = NodeUtils.arrayToList(1, 2);
//        NodeUtils.printList(l.removeNthFromEnd(list, 2));
        NodeUtils.printList(l.removeNthFromEnd(list, 1));
    }
}

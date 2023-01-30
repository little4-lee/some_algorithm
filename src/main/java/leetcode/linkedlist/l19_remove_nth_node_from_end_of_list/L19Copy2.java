package leetcode.linkedlist.l19_remove_nth_node_from_end_of_list;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

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
class L19Copy2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode solder = new ListNode(0);
        solder.next = head;

        ListNode fast = head;
        ListNode slow = solder;
        int count = 0;

        while (fast != null) {
            if (count < n) {
                fast = fast.next;
                count++;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        if (count == n && slow.next != null) {
            slow.next = slow.next.next;
        }

        return solder.next;
    }

    public static void main(String[] args) {
        printList(new L19Copy2().removeNthFromEnd(arrayToList(1), 1));

        System.out.println();
        printList(new L19Copy2().removeNthFromEnd(arrayToList(1, 2, 3, 4, 5), 5));

        System.out.println();
        printList(new L19Copy2().removeNthFromEnd(arrayToList(1, 2, 3, 4, 5), 6));

        System.out.println();
        printList(new L19Copy2().removeNthFromEnd(arrayToList(1, 2, 3, 4, 5), 1));

        System.out.println();
        printList(new L19Copy2().removeNthFromEnd(arrayToList(), 1));
    }
}

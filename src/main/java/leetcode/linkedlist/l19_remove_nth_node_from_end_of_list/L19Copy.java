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
class L19Copy {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode solder = new ListNode(0);
        solder.next = head;
        ListNode fast = solder;
        ListNode slow = solder;
        int count = 0;

        while (count < n) {
            fast = fast.next;
            count++;
        }

        while (fast != null &&
                fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //slow: pre remove node
        slow.next = slow.next.next;
        return solder.next;
    }

    public static void main(String[] args) {
//        ListNode list = arrayToList(1, 2, 3, 4, 5);
//        ListNode list = arrayToList(1, 2);
        ListNode list = arrayToList(1);
//        printList(new L19Copy().removeNthFromEnd(list, 1));
        printList(new L19Copy().removeNthFromEnd(list, 1));
    }
}

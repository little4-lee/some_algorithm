package leetcode.linkedlist.l141_linked_list_cycle;

import common.ListNode;

import static common.ListUtilsKt.addCycle;
import static common.ListUtilsKt.arrayToList;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * <p>
 * Linked List Cycle
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */
public class L141Copy {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode list = arrayToList(1, 2, 3, 4, 5, 6, 7);
        addCycle(list, 4);
        System.out.println(new L141Copy().hasCycle(list));
    }
}

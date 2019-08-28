package linkedlist;

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
public class L141 {
    public boolean hasCycle (ListNode head) {
        if (head == null) return false;

        ListNode quick = head.next;
        ListNode slow = head;

        while (quick != null && quick.next != null) {
            if (quick == slow) {
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }

        return false;
    }
}

package linkedlist;

/**
 * Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 */
public class L142 {
    public ListNode detectCycle (ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        //find cycle
        while (fast != null && fast.next != null) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }

        //no cycle
        if (fast == null || fast.next == null) return null;

        ListNode p = head;
        //find entry
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }

        return p;
    }

    public static void main (String[] args) {
        ListNode head = NodeUtils.arrayToList(1,2,3,4,5,6,7,8);
        NodeUtils.addCycle(head, 6);

        System.out.println(new L142().detectCycle(head).val);
    }
}

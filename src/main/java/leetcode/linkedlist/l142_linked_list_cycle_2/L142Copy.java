package leetcode.linkedlist.l142_linked_list_cycle_2;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;

/**
 * Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position
 * (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 */
class L142Copy {
    public ListNode findCycleEntry(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        //detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }

        //no cycle
        if (fast == null || fast.next == null) return null;

        //find cycle entry
        ListNode p = head;
        //核心知识，数学上能够证明，p和slow会在入口处相遇
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = arrayToList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        addCycle(head, 5);
        ListNode entry = new L142Copy().findCycleEntry(head);
        System.out.println("cycle entry: " + (entry == null ? "null" : entry.value));
    }
}

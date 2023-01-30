package leetcode.linkedlist.l142_linked_list_cycle_2;

import common.ListNode;

import static common.ListUtilsKt.addCycle;
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
class L142Copy3 {
    public ListNode findCycleEntry(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        //no cycle
        if (fast == null || fast.next == null) return null;

        //has cycle
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }

    public static void test() {
        //no cycle
        ListNode list = arrayToList(1,2,3,4,5);
        ListNode entry1 = new L142Copy3().findCycleEntry(list);
        System.out.println("cycle entry: " + (entry1 == null ? "null" : entry1.value));

        //has cycle
        addCycle(list, 2);
        ListNode entry2 = new L142Copy3().findCycleEntry(list);
        System.out.println("cycle entry: " + (entry2 == null ? "null" : entry2.value));

        //null
        ListNode entry3 = new L142Copy3().findCycleEntry(null);
        System.out.println("cycle entry: " + (entry3 == null ? "null" : entry3.value));
    }


    public static void main(String[] args) {
        test();
    }
}

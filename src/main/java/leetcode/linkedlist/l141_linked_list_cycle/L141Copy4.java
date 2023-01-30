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
public class L141Copy4 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void test() {
        ListNode list = arrayToList(1, 2, 3, 4, 5, 6, 7);

        //no cycle
        System.out.println(new L141Copy4().hasCycle(list));

        addCycle(list, 4);
        //has cycle
        System.out.println(new L141Copy4().hasCycle(list));

        //null
        System.out.println(new L141Copy2().hasCycle(null));
    }

    public static void main(String[] args) {
        test();
    }
}

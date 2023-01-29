package leetcode.linkedlist.l92_reverse_linked_list_2;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

/**
 * 92. Reverse Linked List II
 * <p>
 * Given the head of a singly linked list and two integers left and right
 * where left <= right, reverse the nodes of the list from position left to position right,
 * and return the reversed list.
 * <p>
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * <p>
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * Follow up: Could you do it in one pass?
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
class L92Copy6 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode solder = new ListNode(0);
        solder.next = head;
        ListNode p = solder;

        ListNode preStart = null;
        ListNode start = null;
        int count = 0;

        while (count <= n) {
            ListNode pNext = p.next;
            if (count < m) {
                if (count == m - 1) {
                    preStart = p;
                }
            } else {
                //count >= m && count <= n
                if (count == m) {
                    start = p;
                }
                p.next = preStart.next;
                preStart.next = p;
            }
            count++;
            p = pNext;
        }

        start.next = p;
        return solder.next;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        ListNode list1 = arrayToList(1);
        ListNode list2 = arrayToList(1, 2);
        ListNode list3 = arrayToList(1, 2, 3, 4, 5);


        printList(new L92Copy6().reverseBetween(arrayToList(1), 1, 1));
        System.out.println();

        printList(new L92Copy6().reverseBetween(arrayToList(1, 2), 1, 1));
        System.out.println();
        printList(new L92Copy6().reverseBetween(arrayToList(1, 2), 2, 2));
        System.out.println();
        printList(new L92Copy6().reverseBetween(arrayToList(1, 2), 1, 2));


        System.out.println();
        printList(new L92Copy6().reverseBetween(arrayToList(1, 2, 3, 4, 5), 2, 4));
        System.out.println();
        printList(new L92Copy6().reverseBetween(arrayToList(1, 2, 3, 4, 5), 2, 2));
    }
}

package leetcode.linkedlist.l206_reverse_linked_list;

import java.util.LinkedList;
import java.util.List;

import leetcode.linkedlist.ListNode;
import leetcode.linkedlist.NodeUtils;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class L206 {

    public ListNode reverseList (ListNode head) {
        if (head == null) return null;

        ListNode soldier = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode pNext = p.next;
            p.next = soldier.next;
            soldier.next = p;

            p = pNext;
        }

        return soldier.next;
    }

    public static void main (String[] args) {
        List<ListNode> nodes = new LinkedList<>();
        nodes.add(NodeUtils.arrayToList(1, 2, 3, 4, 5));
        nodes.add(NodeUtils.arrayToList(1));
        nodes.add(NodeUtils.arrayToList(1,2));
        nodes.add(NodeUtils.arrayToList());

        L206 l = new L206();
        for (ListNode node : nodes) {
            NodeUtils.printList(l.reverseList(node));
            System.out.println();
        }
    }
}

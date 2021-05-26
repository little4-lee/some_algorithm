package linkedlist.l876_middle_of_the_linked_list;

import java.util.LinkedList;
import java.util.List;

import linkedlist.ListNode;
import linkedlist.NodeUtils;

/**
 * 876. Middle of the Linked List
 *
 * Given a non-empty, singly linked list with head node head,
 * return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class L876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //odd
        if (fast.next == null) return slow;
        //even
        return slow.next;
    }

    public static void main (String[] args) {
        List<ListNode> nodes = new LinkedList<>();
        nodes.add(NodeUtils.arrayToList(1, 2, 6, 3, 4, 5, 1, 2, 6, 3, 4, 5));
        nodes.add(NodeUtils.arrayToList(1, 2, 6, 3, 4, 5));
        nodes.add(NodeUtils.arrayToList(1, 2, 3));
        nodes.add(NodeUtils.arrayToList(1, 2));
        nodes.add(NodeUtils.arrayToList(1));
        L876 l = new L876();
        for (ListNode node: nodes) {
            System.out.println(l.middleNode(node).val);
//            NodeUtils.printList(l.middleNode(node));
        }
    }
}

package linkedlist.l160_intersection_of_two_linked_lists;

import javax.swing.JFormattedTextFieldBeanInfo;

import linkedlist.ListNode;
import linkedlist.NodeUtils;

/**
 * 160. Intersection of Two Linked Lists
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 * <p>
 * <p>
 * It is guaranteed that there are no cycles anywhere in the entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the function returns.
 */
public class L160Copy {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lengthA = 1;
        int lengthB = 1;
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA.next != null || pB.next != null) {
            if (pA.next != null) {
                pA = pA.next;
                lengthA++;
            }

            if (pB.next != null) {
                pB = pB.next;
                lengthB++;
            }
        }

        if (pA != pB) return null;

        int diff = lengthA - lengthB;

        ListNode pA2 = headA;
        ListNode pB2 = headB;
        
        if (diff > 0) for (int i = 0; i < diff; i++) pA2 = pA2.next;
        else for (int i = 0; i < -diff; i++) pB2 = pB2.next;

        while (pA2 != pB2) {
            pA2 = pA2.next;
            pB2 = pB2.next;
        }

        return pA2;
    }

    public static void main (String[] args) {
        ListNode head1 = NodeUtils.arrayToList(1, 2, 3, 3, 2, 1);
        ListNode head2 = NodeUtils.arrayToList(4, 5, 6);
        ListNode head3 = NodeUtils.arrayToList(7, 8, 9);

        NodeUtils.addTail(head1, head3);
        NodeUtils.addTail(head2, head3);

//        ListNode node = new L160Copy().getIntersectionNode(head1, head2);
        ListNode node = new L160Copy().getIntersectionNode(null, null);
        System.out.println(node == null ? "null" : node.val);
    }
}

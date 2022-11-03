package leetcode.linkedlist.l160_intersection_of_two_linked_lists;

import common.ListNode;

import static common.ListUtilsKt.addTail;
import static common.ListUtilsKt.arrayToList;

/**
 * 160. Intersection of Two Linked Lists
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 *
 * It is guaranteed that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 */
public class L160 {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        int lengthA = 1;
        ListNode pB = headB;
        int lengthB = 1;

        //find tail
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
        //different tail, no intersection
        if (pA != pB) return null;

        //clear the difference of length
        pA = headA;
        pB = headB;
        int difference = lengthA - lengthB;
        if (lengthA > lengthB) {
            for (int i = 0; i < difference; i++) {
                pA = pA.next;
            }
        } else {
            for (int i = 0; i < -difference; i++) {
                pB = pB.next;
            }
        }

        //find intersection node
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }

    public static void main (String[] args) {
        ListNode head1 = arrayToList(1, 2, 3, 3, 2, 1);
        ListNode head2 = arrayToList(4, 5, 6);
        ListNode head3 = arrayToList(7, 8, 9);

        addTail(head1, head3);
        addTail(head2, head3);

        ListNode node = new L160().getIntersectionNode(head1, head2);
        System.out.println(node == null ? "null" : node.value);
    }
}

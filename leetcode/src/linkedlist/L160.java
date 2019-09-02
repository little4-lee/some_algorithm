package linkedlist;

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
        ListNode head1 = NodeUtils.arrayToList(1, 2, 3, 3, 2, 1);
        ListNode head2 = NodeUtils.arrayToList(4, 5, 6);
        ListNode head3 = NodeUtils.arrayToList(7, 8, 9);

        NodeUtils.addTail(head1, head3);
        NodeUtils.addTail(head2, head3);

        ListNode node = new L160().getIntersectionNode(head1, head2);
        System.out.println(node == null ? "null" : node.val);
    }
}

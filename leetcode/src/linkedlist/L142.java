package linkedlist;

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

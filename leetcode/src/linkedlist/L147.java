package linkedlist;

public class L147 {
    public ListNode insertionSortList (ListNode head) {
        if (head == null) return null;

        //cur for unsorted node,start sort from second node
        ListNode p = head.next;

        ListNode soldier = new ListNode(8080);
        soldier.next = head;
        head.next = null;

        //cur for sorted node
        ListNode cur;

        //traverse and insert
        while (p != null) {
            ListNode pNext = p.next;
            cur = soldier;

            while (cur.next != null) {
                if (p.val < cur.next.val) {
                    p.next = cur.next;
                    cur.next = p;
                    break;
                } else {
                    cur = cur.next;
                }
            }
            if (cur.next == null) {
                p.next = null;
                cur.next = p;
            }

            p = pNext;
        }

        return soldier.next;
    }

    public static void main (String[] args) {
        ListNode list = NodeUtils.arrayToList(2,4,5,6,3,1,9,3,3,3);
        NodeUtils.printList(new L147().insertionSortList(list));
    }
}

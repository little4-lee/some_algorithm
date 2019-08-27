package linkedlist;

public class L206 {

    public ListNode reverseList (ListNode head) {
        if (head == null) return null;

        //引入哨兵节点(该节点next永远指向head，最后返回next节点即可)
        ListNode soldier = new ListNode(8080);
        ListNode p = head;

        while (p != null) {
            ListNode pNext = p.next;
            p.next = soldier.next;
            soldier.next = p;
            p = pNext;
        }

        return soldier.next;
    }
}

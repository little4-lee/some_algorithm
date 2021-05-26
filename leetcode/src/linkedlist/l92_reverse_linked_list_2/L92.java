package linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class L92 {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;

        int index = 1;
        //哨兵节点，next指向head，简化逻辑
        ListNode soldier = new ListNode(8080);

        ListNode p = head;
        //reverse 的起点前一个节点
        ListNode preStart = null;
        if (m == 1) preStart = soldier;
        //reverse 的起点
        ListNode start = null;

        soldier.next = head;

        while (p != null && index <= n) {
            ListNode pNext = p.next;
            if (index == m - 1) {
                preStart = p;
            }

            if (index >= m) {

                if (index == m) {
                    start = p;
                }

                p.next = preStart.next;
                preStart.next = p;
            }

            index++;
            p = pNext;
        }

        start.next = p;

        return soldier.next;
    }
}

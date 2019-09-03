package linkedlist;

public class NodeUtils {
    public static ListNode arrayToList (int... array) {
        if (array == null) return null;

        ListNode head = null;
        ListNode temp = null;
        ListNode pre = null;
        for (int i = 0; i < array.length; i++) {
            temp = new ListNode(array[i]);
            if (i == 0) {
                head = temp;
            } else {
                pre.next = temp;
            }
            pre = temp;
        }

        return head;
    }

    public static ListNode addCycle (ListNode head, int index) {
        if (head == null || index < 0) return head;

        int curIndex = 0;
        ListNode p = head;
        ListNode cycleStart = null;
        while (p.next != null) {
            if (curIndex == index) cycleStart = p;
            p = p.next;
            curIndex++;
        }
        //p is the end of the list
        p.next = cycleStart;
        return head;
    }

    public static void addTail(ListNode original, ListNode tail) {
        if (original == null || tail == null) return;

        ListNode p = original;
        while (p.next != null) {
            p = p.next;
        }
        p.next = tail;
    }

    public static void printList(ListNode head) {
        if (head == null) System.out.println("empty list");

        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}

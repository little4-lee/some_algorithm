package leetcode.linkedlist.l21_merge_two_sorted_list;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

class L21Copy3 {
    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode solder = new ListNode(0);
        ListNode p = solder, p1 = head1, p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 == null) p.next = p2;
        else p.next = p1;

        return solder.next;
    }

    public static void main(String[] args) {
        ListNode l1 = arrayToList(1, 2, 3, 4, 10, 100);
        ListNode l2 = arrayToList(2, 2, 2, 4, 4, 101, 101, 101, 101);
        printList(new L21Copy3().mergeList(l1, l2));

        System.out.println();
        printList(new L21Copy3().mergeList(arrayToList(1, 2, 3, 4, 10, 100), null));

        System.out.println();
        printList(new L21Copy3().mergeList(null, null));
    }
}

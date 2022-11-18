package leetcode.linkedlist.l23_merge_k_sorted_list;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;


public class L23Copy {
    public ListNode mergeSortedLists(ListNode[] nodes) {
        return mergeLists(nodes, 0, nodes.length - 1);
    }

    private ListNode mergeLists(ListNode[] nodes, int m, int n) {
        if (m > n) return null;
        if (m == n) return nodes[m];
        if (n - m == 1) return mergeTwoList(nodes[m], nodes[n]);
        return mergeTwoList(
                mergeLists(nodes, m, m + (n - m) / 2),
                mergeLists(nodes, m + (n - m) / 2 + 1, n));
    }

    private ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode solder = new ListNode(0);
        ListNode p = solder;
        ListNode p1 = head1;
        ListNode p2 = head2;

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
        if (p2 == null) p.next = p1;
        return solder.next;
    }

    public static void main(String[] args) {
        ListNode a1 = arrayToList(1, 2, 3, 4, 5);
        ListNode a2 = arrayToList(2, 2, 2, 4, 4);
        ListNode a3 = arrayToList(5, 6);
        ListNode a4 = arrayToList(8, 8, 8);
        ListNode[] lists = {a1, a2, a3, a4};
        //        NodeUtils.printList(new L23().mergeKLists(lists));
        printList(new L23Copy().mergeSortedLists(lists));
    }
}

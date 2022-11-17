package leetcode.linkedlist.l206_reverse_linked_list;

import common.ListNode;

import java.util.LinkedList;
import java.util.List;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

class L206Copy {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode solder = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode pNext = p.next;
            p.next = solder.next;
            solder.next = p;
            p = pNext;
        }

        return solder.next;
    }

    public static void main(String[] args) {
        List<ListNode> nodes = new LinkedList<>();
        nodes.add(arrayToList(1, 2, 3, 4, 5));
        nodes.add(arrayToList(1));
        nodes.add(arrayToList(1,2));
        nodes.add(arrayToList());

        L206Copy l = new L206Copy();
        for (ListNode node : nodes) {
            printList(l.reverseList(node));
            System.out.println();
        }
    }
}

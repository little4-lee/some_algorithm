package leetcode.linkedlist.l876_middle_of_the_linked_list;

import common.ListNode;

import java.util.LinkedList;
import java.util.List;

import static common.ListUtilsKt.arrayToList;

/**
 * @ClassName: L876Copy
 * @Author: elon
 * @CreateDate: 2022/11/17 16:15
 * @Description:
 */
class L876Copy {
    public ListNode findMiddleNode(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }

    public static void main(String[] args) {
        List<ListNode> nodes = new LinkedList<>();
        nodes.add(arrayToList(1, 2, 6, 3, 4, 5, 1, 2, 6, 3, 4, 5));
        nodes.add(arrayToList(1, 2, 6, 3, 4, 5));
        nodes.add(arrayToList(1, 2, 3));
        nodes.add(arrayToList(1, 2));
        nodes.add(arrayToList(1));
        nodes.add(null);
        L876Copy l = new L876Copy();
        for (ListNode node: nodes) {
            ListNode middleNode = l.findMiddleNode(node);
            String value = middleNode == null ? "null" : String.valueOf(middleNode.value);
            System.out.println("middle: " + value);
//            NodeUtils.printList(l.middleNode(node));
        }
    }
}

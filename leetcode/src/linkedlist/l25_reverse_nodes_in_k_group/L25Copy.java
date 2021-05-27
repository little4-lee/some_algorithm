package linkedlist.l25_reverse_nodes_in_k_group;

import linkedlist.ListNode;
import linkedlist.NodeUtils;

/**
 * 25. Reverse Nodes in k-Group
 * Hard
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * eg:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 *
 * Input: head = [1], k = 1
 * Output: [1]
 *
 * 思路:
 * 哨兵 - head
 *
 * 注意哨兵的移动
 *
 * 两层循环
 * - 外层
 * - 内层，每次执行k次
 *
 */
public class L25Copy {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode soldier = new ListNode(0);
        soldier.next = head;

        int count = 0;
        ListNode p = soldier;

        ListNode start = null;
        ListNode preStart = null;

        int index;
        ListNode pInner;

        while (p.next != null) {

            if (count % k == 0) {
                start = p.next;
                preStart = p;
            }

            count++;
            p = p.next;

            if (count % k == 0) {
                ListNode pNext = p.next;

                index = 1;
                pInner = start;

                while (index <= k) {
                    index++;
                    ListNode next = pInner.next;
                    pInner.next = preStart.next;
                    preStart.next = pInner;
                    pInner = next;
                }

                start.next = pNext;
                p = start;
            }
        }

        return soldier.next;
    }

    public static void main (String[] args) {
//        ListNode node = NodeUtils.arrayToList(1, 2, 3, 4, 5, 6, 7, 8);
//        ListNode node = NodeUtils.arrayToList(1, 2, 3, 4);
        ListNode node = NodeUtils.arrayToList(1, 2);
//        ListNode node = NodeUtils.arrayToList(1, 2, 3);
        NodeUtils.printList(new L25Copy().reverseKGroup(node, 2));
    }
}
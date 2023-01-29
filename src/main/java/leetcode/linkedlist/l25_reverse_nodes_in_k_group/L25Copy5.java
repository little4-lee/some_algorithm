package leetcode.linkedlist.l25_reverse_nodes_in_k_group;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

/**
 * 25. Reverse Nodes in k-Group
 * Hard
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * Follow up:
 * <p>
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * eg:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * <p>
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 * <p>
 * Input: head = [1], k = 1
 * Output: [1]
 * <p>
 * 思路:
 * 哨兵 - head
 * <p>
 * 注意哨兵的移动
 * <p>
 * 两层循环
 * - 外层
 * - 内层，每次执行k次
 */
public class L25Copy5 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode solder = new ListNode(0);
        solder.next = head;
        ListNode p = solder;

        ListNode preStart = null, start = null;
        int count = 0;

        while (p.next != null) {
            if (count % k == 0) {
              preStart = p;
              start = p.next;
            }
            count++;
            p = p.next;

            if (count % k == 0) {
                //reverse
                ListNode pNext = p.next;
                ListNode pInner = start;
                int index = 1;

                while (index <= k) {
                    ListNode innerNext = pInner.next;

                    pInner.next = preStart.next;
                    preStart.next = pInner;

                    index++;
                    pInner = innerNext;
                }

                start.next = pNext;
                p = start;
            }
        }

        return solder.next;
    }

    public static void main(String[] args) {
        ListNode node = arrayToList(1, 2, 3, 4, 5, 6, 7, 8);
//        ListNode node = NodeUtils.arrayToList(1, 2, 3, 4);
//        ListNode node = arrayToList(1, 2);
//        ListNode node = NodeUtils.arrayToList(1, 2, 3);
        printList(new L25Copy5().reverseKGroup(node, 3));
        printList(new L25Copy5().reverseKGroup(null, 3));
    }
}
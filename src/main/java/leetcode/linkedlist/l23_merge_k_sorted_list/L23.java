package leetcode.linkedlist.l23_merge_k_sorted_list;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class L23 {

    /**
     * traverse all node everytime
     *
     * @param lists
     * @return
     *
     * time: O(nk)
     *      ==> n = k * m
     *      ==> m = average list length
     * space: O(1)
     */

    //    public ListNode mergeKLists (ListNode[] lists) {
    //        if (lists == null) return null;
    //        ListNode soldier = new ListNode(8080);
    //        ListNode p = soldier;
    //        ListNode[] curs = new ListNode[lists.length];
    //
    //        for (int i = 0; i < lists.length; i++) {
    //            curs[i] = lists[i];
    //        }
    //
    //        int minIndex;
    //        while (!isTail(curs)) {
    //            minIndex = -1;
    //            for (int i = 0; i < curs.length; i++) {
    //                if (curs[i] == null) continue;
    //
    //                if (minIndex == -1) {
    //                    minIndex = i;
    //                    continue;
    //                }
    //
    //                if (curs[i].val < curs[minIndex].val) {
    //                    minIndex = i;
    //                }
    //            }
    //            p.next = curs[minIndex];
    //            p = p.next;
    //            curs[minIndex] = curs[minIndex].next;
    //            p.next = null;
    //        }
    //
    //        return soldier.next;
    //    }
    private boolean isTail (ListNode[] curs) {
        if (curs == null) return true;
        for (ListNode node : curs) {
            if (node != null) return false;
        }
        return true;
    }


    /**
     * divide and conquer
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists (ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * recursive method
     * @param lists
     * @param start
     * @param end
     * @return
     *
     * time: O(nlogk)
     *      ==> n = k * m
     *      ==> m = average list length
     * space: O(1)
     */
    private ListNode merge (ListNode[] lists, int start, int end) {
        if (lists == null || start > end) return null;
        if (start == end) return lists[start];
        if (1 == end - start) return mergeTwo(lists[start], lists[end]);

        int middle = (start + end) / 2;
        return mergeTwo(merge(lists, start, middle), merge(lists, middle + 1, end));
    }

    /**
     * merge two linked list
     *
     * @param a
     * @param b
     * @return
     *
     * time: O(n) ==> n = a.length + b.length
     * space: O(1)
     */
    private ListNode mergeTwo (ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode soldier = new ListNode(8080);

        ListNode p = soldier;
        ListNode pA = a;
        ListNode pB = b;

        while (pA != null && pB != null) {
            if (pA.value < pB.value) {
                p.next = pA;
                pA = pA.next;
            } else {
                p.next = pB;
                pB = pB.next;
            }
            p = p.next;
        }

        if (pA != null) {
            p.next = pA;
        }

        if (pB != null) {
            p.next = pB;
        }

        return soldier.next;
    }

    public static void main (String[] args) {
        ListNode a1 = arrayToList(1, 2, 3, 4, 5);
        ListNode a2 = arrayToList(2, 2, 2, 4, 4);
        ListNode a3 = arrayToList(5, 6);
        ListNode a4 = arrayToList(8, 8, 8);
        ListNode[] lists = {a1, a2, a3, a4};
        //        NodeUtils.printList(new L23().mergeKLists(lists));
        printList(new L23().mergeKLists(lists));
    }


}

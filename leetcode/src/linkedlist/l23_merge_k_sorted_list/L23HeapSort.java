package linkedlist.l23_merge_k_sorted_list;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;
import linkedlist.ListNode;
import linkedlist.NodeUtils;

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
public class L23HeapSort {

    /**
     * traverse all node everytime
     *
     * @param lists
     * @return time: O(nk)
     * ==> n = k * m
     * ==> m = average list length
     * space: O(1)
     */

    public ListNode mergeKLists (ListNode[] lists) {
        if (lists == null) return null;

        ListNode soldier = new ListNode(0);
        ListNode tail = soldier;
        // TODO: 2021/5/30 check 边界
        ListNode[] nodes = buildHeap(lists);

        //sort
        int n = nodes.length - 1;
        while (n > 0) {
            ListNode min = nodes[1];
            ListNode next = min.next;
            tail.next = min;
            tail = min;

            if (next == null) {
                swap(nodes, n, 1);
                n--;
            } else {
                nodes[1] = next;
            }
            heapify(nodes, n, 1);
        }

        return soldier.next;
    }

    private ListNode[] buildHeap (ListNode... lists) {
        int n = lists.length;
        ListNode[] nodes = new ListNode[n + 1];
        System.arraycopy(lists, 0, nodes, 1, n);
        for (int i = n / 2; i >= 1; i--) {
            heapify(nodes, n, i);
        }
        return nodes;
    }

    /**
     * 堆化: 自上而下
     * @param nodes
     * @param n
     * @param i
     */
    private void heapify (ListNode[] nodes, int n, int i) {
        while (true) {
            int minPos = i;
            if (i * 2 <= n && nodes[i].val > nodes[i * 2].val) minPos = i * 2;
            if (i * 2 + 1 <= n && nodes[minPos].val > nodes[i * 2 + 1].val) minPos = i * 2 + 1;
            if (minPos == i) break;
            swap(nodes, i, minPos);
            i = minPos;
        }
    }

    private void swap (Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main (String[] args) {
        ListNode a1 = NodeUtils.arrayToList(1, 2, 3, 4, 5);
        ListNode a2 = NodeUtils.arrayToList(2, 2, 2, 4, 4);
        ListNode a3 = NodeUtils.arrayToList(5, 6);
        ListNode a4 = NodeUtils.arrayToList(8, 8, 8);
        ListNode[] lists = {a1, a2, a3, a4};
        //        NodeUtils.printList(new L23().mergeKLists(lists));
//        NodeUtils.printList(new L23HeapSort().mergeKLists(lists));
        NodeUtils.printList(new L23HeapSort().mergeKLists(new ListNode[]{a1}));
    }


}

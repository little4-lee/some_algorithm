package leetcode.linkedlist.l23_merge_k_sorted_list;

import common.ListNode;

import static common.ArrayUtilsKt.swap;
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
public class L23HeapSortCopy3 {

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
        //暂不考虑list中元素为空

        buildHeap(lists, lists.length - 1);

        ListNode solder = new ListNode(0);
        ListNode tail = solder;
        int count = lists.length - 1;
        while (count >= 0) {
            //pick heap top
            ListNode top = lists[0];
            ListNode next = top.next;
            tail.next = top;
            tail = top;

            if (next == null) {
                //有一个队列排序结束
                swap(lists, 0, count);
                count--;
            } else {
                lists[0] = next;
            }
            heaping(lists, count, 0);
        }

        return solder.next;
    }

    /**
     * 建堆
     * 从第一个非叶子结点开始堆化
     * @param lists
     * @param n
     */
    private void buildHeap(ListNode[] lists, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heaping(lists, n, i);
        }
    }

    /**
     * 堆化
     * 下标从 i 到 n
     * @param lists
     * @param n
     * @param i
     */
    private void heaping(ListNode[] lists, int n, int i) {
        while (true) {
            int minPos = i;
            int l = 2 * i + 1;
            int r = 2 * (i + 1);
            if (l <= n && lists[l].value < lists[minPos].value) minPos = l;
            if (r <= n && lists[r].value < lists[minPos].value) minPos = r;
            if (minPos == i) break;
            swap(lists, i, minPos);
            i = minPos;
        }
    }


    public static void main (String[] args) {
        ListNode a1 = arrayToList(1, 2, 3, 4, 5);
        ListNode a2 = arrayToList(2, 2, 2, 4, 4);
        ListNode a3 = arrayToList(5, 6);
        ListNode a4 = arrayToList(8, 8, 8);
        ListNode[] lists = {a1, a2, a3, a4};
        printList(new L23HeapSortCopy3().mergeKLists(lists));
    }
}

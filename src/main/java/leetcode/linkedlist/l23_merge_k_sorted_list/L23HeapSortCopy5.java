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
public class L23HeapSortCopy5 {

    /**
     * traverse all node everytime
     *
     * @param lists
     * @return time: O(nk)
     * ==> n = k * m
     * ==> m = average list length
     * space: O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //TODO check
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) throw new IllegalArgumentException("list has null element");
        }

        //build heap
        buildHeap(lists);

        //merge
        ListNode solder = new ListNode(0);
        ListNode p = solder;
        //last element index of heap
        int k = lists.length - 1;
        while (k > 0) {
            //pop
            ListNode headNext = lists[0].next;
            p.next = lists[0];
            p = p.next;

            if (headNext == null) {
                //list[0] is null
                swap(lists, 0, k);
                k--;
            } else {
                lists[0] = headNext;
            }
            heaping(lists, 0, k);
        }

        p.next = lists[0];
        return solder.next;
    }

    /**
     * 建堆
     * 从 第一个非叶子节点 到 根节点，以此向下堆化
     * @param lists
     */
    private void buildHeap(ListNode[] lists) {
        int start = (lists.length - 2) / 2;
        for (int i = start; i >= 0; i--) {
            heaping(lists, i, lists.length - 1);
        }
    }

    /**
     * 堆化
     * @param lists
     * @param i 开始位置
     * @param k 结束边界
     */
    private void heaping(ListNode[] lists, int i, int k) {
        while (true) {
            int minPos = i;
            int leftPos = 2 * i + 1;
            int rightPos = 2 * i + 2;
            if (leftPos <= k && lists[leftPos].value < lists[minPos].value) minPos = leftPos;
            if (rightPos <= k && lists[rightPos].value < lists[minPos].value) minPos = rightPos;
            if (minPos == i) break;
            swap(lists, i, minPos);
            i = minPos;
        }
    }


    public static void test() {
        ListNode[] lists = {
                arrayToList(1, 2, 3, 4, 5),
                arrayToList(2, 2, 2, 4, 4),
                arrayToList(5, 6),
                arrayToList(8, 8, 8),
//                null
        };
        printList(new L23HeapSortCopy5().mergeKLists(lists));
    }


    public static void main(String[] args) {
        test();
    }
}

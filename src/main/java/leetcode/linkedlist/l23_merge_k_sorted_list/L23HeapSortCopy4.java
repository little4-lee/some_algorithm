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
public class L23HeapSortCopy4 {

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
        if (lists == null || lists.length == 0) return null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) throw new IllegalArgumentException("lists has null params");
        }

        //build heap
        buildHeap(lists);

        //merge
        //heap 最后一个元素的下标
        ListNode solder = new ListNode(0);
        ListNode p = solder;
        int k = lists.length - 1;
        while (k > 0) {
            //提取堆顶元素
            p.next = lists[0];
            p = p.next;
            ListNode headNext = lists[0].next;
            if (headNext == null) {
                //完成一个 list 的 merge
                swap(lists, 0, k);
                k--;
            } else {
                lists[0] = headNext;
            }
            heaping(lists, 0, k);
        }

        //merge last list
        p.next = lists[0];

        return solder.next;
    }

    /**
     * 建堆
     * 从 第一个 非叶子节点开始堆化
     *
     * @param lists
     */
    private void buildHeap(ListNode[] lists) {
        int n = lists.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heaping(lists, i, n - 1);
        }
    }

    /**
     * 堆化
     *
     * @param lists
     * @param i     开始位置
     * @param n     结束边界
     */
    private void heaping(ListNode[] lists, int i, int n) {
        while (true) {
            int minPos = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l <= n && lists[l].value < lists[minPos].value) minPos = l;
            if (r <= n && lists[r].value < lists[minPos].value) minPos = r;
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
        printList(new L23HeapSortCopy4().mergeKLists(lists));
    }

    public static void main(String[] args) {
        test();
    }
}

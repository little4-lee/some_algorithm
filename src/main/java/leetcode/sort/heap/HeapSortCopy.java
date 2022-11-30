package leetcode.sort.heap;

import static common.ArrayUtilsKt.swap;

/**
 * @ClassName: HeapSortCopy
 * @Author: elon
 * @CreateDate: 2022/11/30 11:40
 * @Description:
 */
public class HeapSortCopy {
    public void heapSort(int[] nums) {
        if (nums == null) return;
        buildHeap(nums, nums.length - 1);
        int count = nums.length - 1;
        while (count >= 0) {
            swap(nums, 0, count);
            count--;
            heaping(nums, count, 0);
        }
    }

    /**
     * 建堆
     * 从第一个非叶子节点开始
     * @param nums
     * @param n
     */
    private void buildHeap(int[] nums, int n) {
        for (int i = (n - 1) / 2; i >= 0 ; i--) {
            heaping(nums, n, i);
        }
    }

    /**
     * 堆化
     * @param nums
     * @param n 截止节点
     * @param i 开始节点
     */
    private void heaping(int[] nums, int n, int i) {
        while (true) {
            int maxPos = i;
            int l = 2 * i + 1;
            int r = 2 * (i + 1);
            if (l <= n && nums[l] > nums[maxPos]) maxPos = l;
            if (r <= n && nums[r] > nums[maxPos]) maxPos = r;
            if (maxPos == i) break;
            swap(nums, i, maxPos);
            i = maxPos;
        }
    }
}

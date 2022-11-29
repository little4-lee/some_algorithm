package leetcode.tree;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

public class HeapCopy5 {

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

    private void heaping(int[] nums, int n, int i) {
        while (true) {
            int maxPos = i;
            int l = 2 * i + 1;
            int r = 2 * (i + 1);
            if (l <= n && nums[l] > nums[maxPos]) maxPos = l;
            if (r <= n && nums[r] > nums[maxPos]) maxPos = r;
            if (maxPos == i) break;
            swap(nums, maxPos, i);
            i = maxPos;
        }
    }

    private void buildHeap(int[] nums, int n) {
        //建堆，从第一个非叶子结点开始
        for (int i = (n - 1) / 2; i >= 0 ; i--) {
            heaping(nums, n, i);
        }
    }

    public static void main (String[] args) {
        int[] a = {0, 3, 2, 1, 5, 6, 7, 8, 9};
        printArray(a);
        System.out.println();
        System.out.println();
        HeapCopy5 heap = new HeapCopy5();
        heap.heapSort(a);
        printArray(a);
    }
}

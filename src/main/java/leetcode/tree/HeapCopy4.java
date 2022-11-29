package leetcode.tree;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

public class HeapCopy4 {

    public void heapSort(int[] nums) {
        if (nums == null) return;
        buildHeap(nums, nums.length - 1);
        System.out.println();
        sort(nums, nums.length - 1);
    }

    private void sort(int[] nums, int n) {
        int k = n;
        while (k >= 0) {
            swap(nums, 0, k);
            k--;
            heapify(nums, k, 0);
        }
    }

    private int leftIndex(int index) {
        return 2 * index + 1;
    }

    private int rightIndex(int index) {
        return 2 * (index + 1);
    }

    private int root(int index) {
        return (index- 1) /2;
    }

    private void buildHeap(int[] nums, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }

    /**
     * 堆化
     * @param nums data
     * @param n count
     * @param i from which
     */
    private void heapify(int[] nums, int n, int i) {
        System.out.println("heapify log: index: " + i + " value: " + nums[i]);
        while (true) {
            int maxPos = i;
            int l = leftIndex(i);
            int r = rightIndex(i);
            if (l <= n && nums[l] > nums[i]) maxPos = l;
            if (r <= n && nums[r] > nums[maxPos]) maxPos = r;
            if (maxPos == i) break;
            swap(nums, maxPos, i);
            i = maxPos;
        }
        printArray(nums);
        System.out.println("-------");
    }

    public static void main (String[] args) {
        int[] a = {0, 3, 2, 1, 5, 6, 7, 8, 9};
        printArray(a);
        System.out.println();
        System.out.println();
        HeapCopy4 heap = new HeapCopy4();
        heap.heapSort(a);
        printArray(a);
    }
}

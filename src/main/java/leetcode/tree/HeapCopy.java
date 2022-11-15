package leetcode.tree;

public class HeapCopy {

    private void heapSort (int[] nums) {
        buildHeap(nums);
        sort(nums, nums.length - 1);
    }

    private void buildHeap (int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            while (i / 2 > 0 && nums[i] > nums[i / 2]) {
                swap(nums, i, i / 2);
                i = i / 2;
            }
        }
    }

    private void heaping (int[] nums, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && nums[i * 2] >= nums[i]) maxPos = i * 2;
            if (i * 2 + 1 <= count && nums[i * 2 + 1] >= nums[maxPos]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(nums, maxPos, i);
            i = maxPos;
        }
    }

    private void sort (int[] heap, int n) {
        int k = n;
        while (k > 1) {
            swap(heap, k, 1);
            k--;
            heaping(heap, k, 1);
        }
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

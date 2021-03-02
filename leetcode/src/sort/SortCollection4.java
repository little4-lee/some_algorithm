package sort;

public class SortCollection4 {

    public static void main (String[] args) {
        int [] arr = {2, 4, 5, 3, 7};
        SortCollection4 collection = new SortCollection4();
        collection.sort(arr);
        printArr(arr);
    }

    private void sort(int [] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort (int[] nums, int start, int end) {
        if (start >= end) return;

        int partition = partition(nums, start, end);

        quickSort(nums, start, partition - 1);
        quickSort(nums, partition + 1, end);
    }

    private int partition (int[] nums, int start, int end) {

        int p = start;
        int value = nums[end];

        for (int i = start; i < end; i++) {
            if (nums[i] < value) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }

        nums[end] = nums[p];
        nums[p] = value;

        return p;
    }


    private static void printArr (int[] arr) {
        for (int i : arr) System.out.print(i + " ");
    }


}

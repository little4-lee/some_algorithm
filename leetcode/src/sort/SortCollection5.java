package sort;

public class SortCollection5 {

    public static void main (String[] args) {
//        int [] arr = {2, 4, 5, 3, 7};
        int [] arr = {2, 4, 5, 9, 5, 6, 6, 8, 3, 7};
        SortCollection5 collection = new SortCollection5();
        collection.sort(arr);
        printArr(arr);
    }

    private void sort(int [] nums) {
        if (nums == null) return;
//        quickSort(nums, 0, nums.length - 1);
//        bubbleSort(nums, 0, nums.length - 1);
//        insertSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int middle = start + (end - start) / 2;
        mergeSort(nums, start, middle);
        mergeSort(nums, middle + 1, end);

        doMerge(nums, start, middle, middle + 1, end, start, end);
    }

    private void doMerge (int[] nums, int s1, int e1, int s2, int e2, int s, int e) {
        int i = s1;
        int j = s2;
        int count = 0;
        int[] arr = new int[e - s + 1];

        while (i <= e1 && j <= e2) {
            if (nums[i] < nums[j]) arr[count++] = nums[i++];
            else arr[count++] = nums[j++];
        }

        while (i <= e1) {
            arr[count++] = nums[i++];
        }
        while (j <= e2) {
            arr[count++] = nums[j++];
        }

        for (int k = 0; k < arr.length; k++) {
            nums[s + k] = arr[k];
        }
    }

    // TODO: 2021/3/2
    private void insertSort(int[] nums, int start, int end) {

        for (int i = start + 1; i <= end; i++) {
            int value = nums[i];
            for (int j = i - 1; j >= start; j--) {
                //start .. j is sorted
                if (nums[j] > value) nums[j + 1] = nums[j];
                else {
                    nums[j + 1] = value;
                    break;
                }
            }
        }
    }

    private void bubbleSort(int[] nums, int start, int end) {
        boolean moved;
        for (int i = end; i > start; i--) {
            moved = false;
            for (int j = start; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    moved = true;
                }
            }

            if (!moved) {
                break;
            }
        }
    }

    private void quickSort (int[] nums, int start, int end) {
        if (start >= end) return;

        //TODO check recursive depth

        int p = partition(nums, start, end);
        quickSort(nums, start, p - 1);
        quickSort(nums, p + 1, end);
    }

    private int partition (int[] nums, int start, int end) {
        // TODO: check non-end item
        int value = nums[end];
        int p = start;

        for (int i = start; i < end; i++) {
            if (nums[i] < value) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
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

    private void heapSort(int nums, int start, int end) {
        // TODO: 2021/4/15
    }

}

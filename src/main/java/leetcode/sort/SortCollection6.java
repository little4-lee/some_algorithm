package leetcode.sort;

public class SortCollection6 {

    public static void main (String[] args) {
        //        int [] arr = {2, 4, 5, 3, 7};
        int[] arr = {2, 4, 5, 9, 5, 6, 6, 8, 3, 7};
        SortCollection6 collection = new SortCollection6();
        collection.sort(arr);
        printArr(arr);
    }

    private void sort (int[] arr) {
        if (arr == null) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort (int[] arr, int start, int end) {
        if (start >= end) return;
        int index = partition(arr, start, end);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    private int partition (int[] arr, int start, int end) {
        int value = arr[end];
        int count = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < value) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }

        arr[end] = arr[count];
        arr[count] = value;
        return count;
    }

    private static void printArr (int[] arr) {
        for (int i : arr) System.out.print(i + " ");
    }
}

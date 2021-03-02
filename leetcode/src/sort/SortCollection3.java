package sort;

public class SortCollection3 {

    public static void main (String[] args) {
        int [] arr = {2, 4, 5, 3, 7};
        SortCollection3 collection = new SortCollection3();
        collection.sort(arr);
        printArr(arr);
    }

    private void sort (int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort (int[] arr, int start, int end) {
        if (start >= end) return;

        int p = partition(arr, start, end);

        quickSort(arr, start, p - 1);
        quickSort(arr, p + 1, end);
    }

    private int partition (int[] arr, int start, int end) {
        int value = arr[end];
        int partition = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < value) {
                int tmp = arr[i];
                arr[i] = arr[partition];
                arr[partition] = tmp;
                partition++;
            }
        }

        arr[end] = arr[partition];
        arr[partition] = value;

        return partition;
    }


    private static void printArr (int[] arr) {
        for (int i : arr) System.out.print(i + " ");
    }


}

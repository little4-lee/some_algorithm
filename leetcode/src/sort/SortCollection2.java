package sort;

public class SortCollection2 {

    public static void main (String[] args) {
        int [] arr = {2, 4, 5, 3, 7};
        SortCollection2 collection = new SortCollection2();
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
        int p = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < value) {
                int tmp = arr[i];
                arr[i] = arr[p];
                arr[p] = arr[i];
                p++;
            }
        }
        arr[end] = arr[p];
        arr[p] = value;

        return p;
    }

    private static void printArr (int[] arr) {
        for (int i : arr) System.out.print(i + " ");
    }


}

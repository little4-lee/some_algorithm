package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortCollection7 {

    private static List<ISort> mSorts = new LinkedList<>();

    static {
        mSorts.add(new BubbleSort());
        mSorts.add(new InsertionSort());
        mSorts.add(new SelectionSort());
        mSorts.add(new MergeSort());
        mSorts.add(new QuickSort());
        mSorts.add(new HeapSort());
    }

    public static void main (String[] args) {

        int[][] arrs = {
                {2, 4, 5, 9, 5, 6, 6, 8, 3, 7}, {1}, {3, 2}, {}, null};


        for (ISort sort : mSorts) {
            System.out.println(sort.getClass().getSimpleName() + " ==> ");
            for (int[] arr : arrs) {
                int[] arrCopy = arr == null ? null : Arrays.copyOf(arr, arr.length);
                System.out.println("before");
                printArr(arrCopy);
                sort.sort(arrCopy);
                System.out.println();
                System.out.println("after");
                printArr(arrCopy);
                System.out.println();
            }
            System.out.println();
        }
    }


    private static class BubbleSort implements ISort {
        @Override
        public void sort (int[] arr) {
        }
    }

    private static class SelectionSort implements ISort {
        @Override
        public void sort (int[] arr) {
            // TODO: 2021/5/29
        }
    }

    private static class InsertionSort implements ISort {
        @Override
        public void sort (int[] arr) {
            // TODO: 2021/5/29
        }
    }

    private static class MergeSort implements ISort {
        @Override
        public void sort (int[] arr) {
            // TODO: 2021/5/29
        }
    }

    private static class QuickSort implements ISort {
        @Override
        public void sort (int[] arr) {
            // TODO: 2021/5/29
        }
    }

    private static class HeapSort implements ISort {
        @Override
        public void sort (int[] arr) {
            // TODO: 2021/5/29
        }
    }

    private static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr (int[] arr) {
        if (arr == null) {
            System.out.println("null array");
            return;
        }
        if (arr.length == 0) {
            System.out.println("empty array");
        }
        for (int i : arr) System.out.print(i + " ");
    }
}


interface ISort {
    void sort (int[] arr);
}
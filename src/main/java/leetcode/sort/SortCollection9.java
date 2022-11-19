package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;

class SortCollection9 {
    private interface ISort {
        void sort(int[] arr);
    }

    private final static class BubbleSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;

            int n = arr.length;
            for (int i = n - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }
    }

    private final static class InsertionSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;

            for (int i = 1; i < arr.length; i++) {
                int insertion = i;
                int value = arr[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] > value) {
                        insertion = j;
                        arr[j + 1] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[insertion] = value;
            }
        }
    }

    private final static class SelectionSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            for (int i = 0; i < arr.length - 1; i++) {
                int selection = i;
                int minValue = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < minValue) {
                        minValue = arr[j];
                        selection = j;
                    }
                }
                swap(arr, i, selection);
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        if (arr == null) return;
        int n = arr.length;
        if (i < 0 || i > n || j < 0 || j > n || i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] arrList = {{2, 4, 5, 9, 5, 6, 6, 8, 3, 7}, {1}, {3, 2}, {2, 3}, {}, null};

        List<ISort> sorts = new LinkedList<>();

        sorts.add(new BubbleSort());
        sorts.add(new InsertionSort());
        sorts.add(new SelectionSort());
        for (ISort sort : sorts) {
            System.out.println(sort.getClass().getSimpleName() + " ==> ");
            for (int[] arr : arrList) {
                int[] arrCopy = arr == null ? null : Arrays.copyOf(arr, arr.length);
                printArray(arrCopy);
                sort.sort(arrCopy);
                System.out.println();
                printArray(arrCopy);
                System.out.println();
                System.out.println("---------");
            }
        }
    }
}
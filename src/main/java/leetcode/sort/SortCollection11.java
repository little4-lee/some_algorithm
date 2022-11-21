package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

class SortCollection11 {

    private static class QuickSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int m, int n) {
            if (m >= n) return;
            int position = partition(arr, m, n);
            quickSort(arr, m, position - 1);
            quickSort(arr, position + 1, n);
        }

        private int partition(int[] arr, int m, int n) {
            int value = arr[n];
            int position = m;

            for (int i = m; i < n; i++) {
                if (arr[i] < value) {
                    swap(arr, position, i);
                    position++;
                }
            }
            swap(arr, position, n);
            return position;
        }
    }
    public static void main(String[] args) {
        int[][] arrList = {{2, 4, 5, 9, 5, 6, 6, 8, 3, 7}, {1}, {3, 2}, {2, 3}, {}, null};

        List<ISort> sorts = new LinkedList<>();

        sorts.add(new QuickSort());
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

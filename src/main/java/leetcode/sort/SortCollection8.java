package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;

class SortCollection8 {
    interface ISort {
        void sort(int[] arr);
    }
    private static class BubbleSort implements ISort{

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            int n = arr.length;
            for (int i = n - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        if (arr == null) return;
        int n = arr.length;
        if (i < 0 || i > n || j < 0 || j > n) return;

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] arrList = {{2, 4, 5, 9, 5, 6, 6, 8, 3, 7}, {1}, {3, 2}, {}, null};

        List<ISort> sorts = new LinkedList<>();

        sorts.add(new BubbleSort());
        for (ISort sort: sorts) {
            System.out.println(sort.getClass().getSimpleName() + " ==> ");
            for (int[] arr : arrList) {
                int[] arrCopy = arr == null ? null : Arrays.copyOf(arr, arr.length);
                System.out.println("before");
                printArray(arrCopy);
                sort.sort(arrCopy);
                System.out.println();
                System.out.println("after");
                printArray(arrCopy);
                System.out.println();
            }
        }
    }
}

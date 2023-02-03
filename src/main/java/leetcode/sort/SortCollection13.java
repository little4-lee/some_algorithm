package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

class SortCollection13 {

    private final static class BubbleSort implements ISort {

        @Override
        public void sort(int[] arr) {
        }
    }

    private final static class InsertionSort implements ISort {

        @Override
        public void sort(int[] arr) {
        }
    }

    private final static class SelectionSort implements ISort {

        @Override
        public void sort(int[] arr) {
        }
    }

    private final static class QuickSort implements ISort {
        @Override
        public void sort(int[] arr) {

        }
    }

    private final static class HeapSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null || arr.length <= 1) return;

            //build heap
            buildHeap(arr);

            //sort
            //k: last element index of heap
            int k = arr.length - 1;
            while (k > 0) {
                swap(arr, 0, k);
                k--;
                heaping(arr, 0, k);
            }
        }

        /**
         * 建堆
         * 从 第一个 非叶子节点 到 根节点
         * @param arr
         */
        private void buildHeap(int[] arr) {
            int start = (arr.length - 2) / 2;
            for (int i = start; i >= 0; i--) {
                heaping(arr, i, arr.length - 1);
            }
        }

        /**
         * 堆化
         * @param arr
         * @param i 开始位置
         * @param n 结束边界
         */
        private void heaping(int[] arr, int i, int n) {
            while (true) {
                int maxPos = i;
                int l = 2 * i + 1;
                int r = 2 * i + 2;
                if (l <= n && arr[l] > arr[maxPos]) maxPos = l;
                if (r <= n && arr[r] > arr[maxPos]) maxPos = r;
                if (maxPos == i) break;
                swap(arr, i, maxPos);
                i = maxPos;
            }
        }
    }


    public static void test() {
        int[][] arrList = {{2, 4, 5, 9, 5, 6, 6, 8, 3, 7}, {1}, {3, 2}, {2, 3}, {}, null};

        List<ISort> sorts = new LinkedList<>();

        sorts.add(new BubbleSort());
        sorts.add(new InsertionSort());
        sorts.add(new SelectionSort());
        sorts.add(new QuickSort());
        sorts.add(new HeapSort());
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

    public static void main(String[] args) {
        test();
    }
}
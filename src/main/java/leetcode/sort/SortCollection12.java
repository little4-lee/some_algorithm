package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

class SortCollection12 {

    private final static class BubbleSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null || arr.length <= 1) return;

            for (int i = arr.length - 1; i > 0; i--) {
                //找到 i 位置的值
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
                }
            }
        }
    }

    private final static class InsertionSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;

            for (int i = 1; i < arr.length; i++) {
                // 0..i-1 有序数组
                // 将 i 插入到前面的有序数组中
                int value = arr[i];
                //插入位置
                int insertion = i;
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
            if (arr == null) return;
            buildHeap(arr);
            //arr tail to sort
            int n = arr.length - 1;
            while (n > 0) {
                swap(arr, 0, n);
                n--;
                heaping(arr, 0, n);
            }
        }

        /**
         * 建堆
         * 从{s}到 0 向下堆化
         * {s}: (arr.length - 2) / 2 第一个非叶子节点
         *
         * @param arr
         */
        private void buildHeap(int[] arr) {
            for (int i = (arr.length - 2) / 2; i >= 0; i--) {
                heaping(arr, i, arr.length - 1);
            }
        }

        /**
         * 堆化
         * 从 i 到 n
         *
         * @param arr
         * @param i   开始位置
         * @param n   结束位置
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

package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

class SortCollection14 {

    private final static class BubbleSort implements ISort {

        @Override
        public void sort(int[] arr) {}
    }

    private final static class InsertionSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;

            for (int i = 1; i < arr.length; i++) {
                // 0 .. i-1 有序
                // 将i插入到 0 .. i 之间
                // 插入位置
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

            for (int i = arr.length - 1; i > 0; i--) {
                //选择 0..i 之间的最大值，放到 i 的位置
                int maxPos = i;
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[maxPos]) maxPos = j;
                }
                swap(arr, i, maxPos);
            }
        }
    }

    private final static class QuickSort implements ISort {
        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int m, int n) {
            if (m >= n) return;
            int partition = partition(arr, m, n);
            quickSort(arr, m, partition - 1);
            quickSort(arr, partition + 1, n);
        }

        /**
         * 分区函数
         * 找到arr[n] 的最终位置
         * 左边都小于该值
         * 右边都大于等于该值
         * @param arr
         * @param m
         * @param n
         * @return
         */
        private int partition(int[] arr, int m, int n) {
            int value = arr[n];
            int position = m;
            for (int i = m; i < n; i++) {
                if (arr[i] < value) {
                    swap(arr, i, position);
                    position++;
                }
            }
            swap(arr, n, position);
            return position;
        }

    }

    private final static class HeapSort implements ISort {

        @Override
        public void sort(int[] arr) {

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

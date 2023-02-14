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
            if (arr == null) return;

            for (int i = arr.length - 1; i > 0; i--) {
                //寻找 0 .. i 的最大值，放到i的位置
                int maxPos = i;
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[maxPos]) maxPos = j;
                }
                swap(arr, maxPos, i);
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
         * 分区函数：
         * 找到下标为 n 的元素排好序时所在的位置partition
         * 此时，
         * partition左侧的都小于arr[n]
         * partition右侧的都大于等于arr[n]
         * @param arr
         * @param m
         * @param n
         * @return
         */
        private int partition(int[] arr, int m, int n) {
            int value = arr[n];
            int partition = m;
            for (int i = m; i < n; i++) {
                if (arr[i] < value) {
                    swap(arr, i, partition);
                    partition++;
                }
            }
            swap(arr, partition, n);
            return partition;
        }


    }

    private final static class MergeSort implements ISort {
        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            mergeSort(arr, 0, arr.length - 1);
        }

        private void mergeSort(int[] arr, int m, int n) {
            if (m >= n) return;
            int middle = m + (n - m) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);

            doMerge(arr, m, middle, n);
        }

        private void doMerge(int[] arr, int m, int middle, int n) {
            //m .. middle 有序，middle + 1 .. n 有序
            //合并两个有序数组
            int[] temp = new int[n - m + 1];
            int left = m;
            int right = middle + 1;
            int count = 0;
            //merge
            while (left <= middle && right <= n) {
                if (arr[left] < arr[right]) temp[count++] = arr[left++];
                else temp[count++] = arr[right++];
            }

            while (left <= middle) temp[count++] = arr[left++];
            while (right <= n) temp[count++] = arr[right++];

            //copy back
            System.arraycopy(temp, 0, arr, m, temp.length);
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
        sorts.add(new MergeSort());
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

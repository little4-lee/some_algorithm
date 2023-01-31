package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

class SortCollection11 {

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

    private final static class QuickSort implements ISort {
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
                    //arr[i]应该在position的左边
                    swap(arr, i, position);
                    position++;
                }
            }

            swap(arr, position, n);
            return position;
        }
    }

    private final static class HeapSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            buildHeap(arr, arr.length - 1);
            int count = arr.length - 1;
            while (count >= 0) {
                swap(arr, 0, count);
                count--;
                heaping(arr, count, 0);
            }
        }

        /**
         * 建堆
         * 从第一个非叶子节点开始
         *
         * @param nums
         * @param n
         */
        private void buildHeap(int[] nums, int n) {
            for (int i = (n - 1) / 2; i >= 0; i--) {
                heaping(nums, n, i);
            }
        }

        /**
         * 堆化
         *
         * @param nums
         * @param n    截止节点
         * @param i    开始节点
         */
        private void heaping(int[] nums, int n, int i) {
            while (true) {
                int maxPos = i;
                int l = 2 * i + 1;
                int r = 2 * (i + 1);
                if (l <= n && nums[l] > nums[maxPos]) maxPos = l;
                if (r <= n && nums[r] > nums[maxPos]) maxPos = r;
                if (maxPos == i) break;
                swap(nums, i, maxPos);
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

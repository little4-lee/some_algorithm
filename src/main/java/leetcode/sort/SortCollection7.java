package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

public class SortCollection7 {

    private static List<ISort> mSorts = new LinkedList<>();

    static {
        //        mSorts.add(new BubbleSort());
        //        mSorts.add(new InsertionSort());
        //        mSorts.add(new SelectionSort());
//                        mSorts.add(new MergeSort());
//        mSorts.add(new QuickSort());
                mSorts.add(new HeapSort());
    }

    public static void main (String[] args) {

        int[][] arrs = {{2, 4, 5, 9, 5, 6, 6, 8, 3, 7}, {1}, {3, 2}, {}, null};

        for (ISort sort : mSorts) {
            System.out.println(sort.getClass().getSimpleName() + " ==> ");
            for (int[] arr : arrs) {
                int[] arrCopy = arr == null ? null : Arrays.copyOf(arr, arr.length);
                System.out.println("before");
                printArray(arrCopy);
                sort.sort(arrCopy);
                System.out.println();
                System.out.println("after");
                printArray(arrCopy);
                System.out.println();
            }
            System.out.println();
        }
    }


    private static class BubbleSort implements ISort {
        @Override
        public void sort (int[] arr) {
            if (arr == null) return;

            boolean moved;
            for (int i = arr.length - 1; i > 0; i--) {
                moved = false;
                for (int j = 1; j <= i; j++) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                        moved = true;
                    }
                }
                if (!moved) break;
            }
        }
    }

    private static class InsertionSort implements ISort {
        @Override
        public void sort (int[] arr) {
            if (arr == null) return;
            for (int i = 1; i < arr.length; i++) {
                //i: first non sorted index
                int value = arr[i];
                int insert = i;
                for (int j = i; j > 0; j--) {
                    if (arr[j - 1] > value) {
                        arr[j] = arr[j - 1];
                        insert = j - 1;
                    } else {
                        break;
                    }
                }
                arr[insert] = value;
            }
        }
    }

    private static class SelectionSort implements ISort {
        @Override
        public void sort (int[] arr) {
            if (arr == null) return;

            for (int i = arr.length - 1; i > 0; i--) {
                int select = i;
                int max = arr[i];
                for (int j = 0; j < i; j++) {
                    if (arr[j] > max) {
                        select = j;
                        max = arr[j];
                    }
                }
                swap(arr, select, i);
            }
        }
    }

    private static class MergeSort implements ISort {
        @Override
        public void sort (int[] arr) {
            if (arr == null) return;
            merge(arr);
        }

        private void merge (int[] arr) {
            doMerge(arr, 0, arr.length - 1);
        }

        private void doMerge (int[] arr, int from, int to) {
            if (from >= to) return;

            if (to == from + 1) {
                if (arr[from] > arr[to]) swap(arr, from, to);
                return;
            }

            int[] copy = new int[to - from + 1];
            int middle = from + (to - from) / 2;
            doMerge(arr, from, middle);
            doMerge(arr, middle + 1, to);
            int i = from;
            int j = middle + 1;
            int count = 0;
            while (i <= middle || j <= to) {
                if (arr[i] < arr[j]) copy[count++] = arr[i++];
                else copy[count++] = arr[j++];
            }
            System.arraycopy(copy, 0, arr, from, copy.length);
        }
    }

    private static class QuickSort implements ISort {
        @Override
        public void sort (int[] arr) {
            if (arr == null) return;
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort (int[] arr, int start, int end) {
            if (start >= end) return;

            int partition = partition(arr, start, end);
            quickSort(arr, start, partition - 1);
            quickSort(arr, partition + 1, end);
        }

        private int partition (int[] arr, int start, int end) {
            int value = arr[end];

            int partition = start;
            for (int i = start; i < end; i++) {
                if (arr[i] < value) {
                    swap(arr, i, partition);
                    partition++;
                }
            }
            arr[end] = arr[partition];
            arr[partition] = value;
            return partition;
        }
    }

    private static class HeapSort implements ISort {
        @Override
        public void sort (int[] arr) {
            if (arr == null) return;

            int[] copy = buildHeap(arr);
            int k = copy.length - 1;
            while (k > 1) {
                swap(copy, 1, k);
                k--;
                heapify(copy, k, 1);
            }
            System.arraycopy(copy, 1, arr, 0, arr.length);
        }

        /**
         * 建堆
         */
        private int[] buildHeap (int[] arr) {
            int[] copy = new int[arr.length + 1];
            System.arraycopy(arr, 0, copy, 1, arr.length);
            for (int i = arr.length / 2; i >= 1; i--) {
                heapify(copy, arr.length, i);
            }
            return copy;
        }

        /**
         * 堆化: 从上往下
         *
         * @param arr
         * @param n
         * @param i
         */
        private void heapify (int[] arr, int n, int i) {
            while (true) {
                int minPos = i;
                if (i * 2 <= n && arr[i] > arr[i * 2]) minPos = i * 2;
                if (i * 2 + 1 <= n && arr[minPos] > arr[i * 2 + 1]) minPos = i * 2 + 1;
                if (minPos == i) break;
                swap(arr, minPos, i);
                i = minPos;
            }
        }
    }
}
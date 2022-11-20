package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

class SortCollection8 {
    private interface ISort {
        void sort(int[] arr);
    }

    private static class BubbleSort implements ISort {

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

    private static class InsertionSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;

            for (int i = 1; i < arr.length; i++) {
                //to insert value
                int value = arr[i];
                int insertion = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] > value) {
                        //move
                        arr[j + 1] = arr[j];
                        insertion = j;
                    } else {
                        break;
                    }
                }
                arr[insertion] = value;
            }
        }
    }

    private static class SelectionSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            for (int i = 0; i < arr.length; i++) {
                int selection = i;
                int value = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < value) {
                        selection = j;
                        value = arr[j];
                    }
                }
                swap(arr, i, selection);
            }
        }
    }

    private static class QuickSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int i, int j) {
            if (i >= j) return;

            int position = partition(arr, i, j);
            quickSort(arr, i, position - 1);
            quickSort(arr, position + 1, j);
        }

        private int partition(int[] arr, int i, int j) {
            int value = arr[j];
            int position = i;
            for (int k = i; k < j; k++) {
                if (arr[k] < value) {
                    swap(arr, position, k);//小于value的数移动到前面
                    position++;
                }
            }
            swap(arr, position, j);
            return position;
        }
    }

    private static class MergeSort implements ISort {

        @Override
        public void sort(int[] arr) {
            if (arr == null) return;
            mergeSort(arr, 0, arr.length - 1);
        }

        private void mergeSort(int[] arr, int m, int n) {
            if (m >= n) return;
            int p = m + (n - m) / 2;
            mergeSort(arr, m, p);
            mergeSort(arr, p + 1, n);
            doMerge(arr, m, p, n);
        }

        private void doMerge(int[] arr, int m, int p, int n) {
            int[] tmp = new int[n - m + 1];
            int i = m;
            int j = p + 1;
            int count = 0;

            while (i <= p && j <= n) {
                if (arr[i] <= arr[j]) tmp[count++] = arr[i++];
                else tmp[count++] = arr[j++];
            }

            while (i <= p) {
                tmp[count++] = arr[i++];
            }

            while (j <= n) {
                tmp[count++] = arr[j++];
            }
            //re=copy
            for (int k = 0; k < tmp.length; k++) {
                arr[m + k] = tmp[k];
            }
            System.arraycopy(tmp, 0, arr, m, tmp.length - 1);
        }
    }

    public static void main(String[] args) {
        int[][] arrList = {{2, 4, 5, 9, 5, 6, 6, 8, 3, 7}, {1}, {3, 2}, {2, 3}, {}, null};

        List<ISort> sorts = new LinkedList<>();

        sorts.add(new BubbleSort());
        sorts.add(new InsertionSort());
        sorts.add(new SelectionSort());
        sorts.add(new QuickSort());
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
}

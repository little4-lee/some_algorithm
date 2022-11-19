package leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.ArrayUtilsKt.printArray;

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

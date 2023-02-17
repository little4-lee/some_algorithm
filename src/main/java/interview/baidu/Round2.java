package interview.baidu;

import java.util.Stack;

import static common.ArrayUtilsKt.swap;

public class Round2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};//3
        System.out.println(findSingle(arr));
        System.out.println(findSingle2(arr));
        System.out.println(findSingle3(arr));
    }

    private static int findSingle(int[] arr) {
        //-1: no single
        if (arr == null) return -1;

        int[] valArr = new int[arr.length];
        int[] countArr = new int[arr.length];
        int cur = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            boolean has = false;

            for (int j = 0; j < cur; j++) {
                if (val == valArr[j]) {
                    countArr[j] += 1;
                    has = true;
                    break;
                }
            }

            if (!has) {
                valArr[cur] = val;
                countArr[cur] = 1;
                cur++;
            }
        }

        for (int i = 0; i <= cur; i++) {
            if (countArr[i] == 1) {
                return valArr[i];
            }
        }

        return -1;
    }

    private static int findSingle2(int[] arr) {
        if (arr == null) return -1;

        int num = 0;
        for (int i : arr) {
            num ^= i;
        }
        return num;
    }

    private static int findSingle3(int[] arr) {
        if (arr == null) return -1;

        quickSort(arr);
//        Arrays.sort(arr);
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            } else {
                //peek == i
                stack.pop();
            }
        }
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    private static void quickSort(int[] arr) {
        if (arr == null) return;

        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int m, int n) {
        if (m >= n) return;

        int partition = partition(arr, m, n);
        doSort(arr, m, partition - 1);
        doSort(arr, partition + 1, n);
    }

    private static int partition(int[] arr, int m, int n) {
        int value = arr[n];

        int cur = m;
        for (int i = m; i < n; i++) {
            if (arr[i] < value) {
                swap(arr, i, cur);
                cur++;
            }
        }
        swap(arr, cur, n);

        return cur;
    }

}

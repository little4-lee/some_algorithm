package leetcode.tree;

import static common.ArrayUtilsKt.printArray;
import static common.ArrayUtilsKt.swap;

public class HeapCopy2 {

    private final int[] data;

    public HeapCopy2 (int[] data) {
        this.data = data;
    }

    public void heapSort () {
        if (data == null) return;

        buildHeap(data);
        printData();
        sort(data, data.length);
    }

    private void sort (int[] data, int count) {
        int i = count - 1;
        while (i > 1) {
            swap(data, i, 1);
            i--;
            heaping(data, i, 1);
            printData();
        }
    }

    /**
     * 堆化
     *
     * @param data
     * @param count
     * @param i
     */
    private void heaping (int[] data, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && data[i * 2] > data[i]) maxPos = i * 2;
            if (i * 2 + 1 <= count && data[i * 2 + 1] > data[maxPos]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(data, i, maxPos);
            i = maxPos;
        }
    }

    public void printData () {
        printArray(data);
    }

    /**
     * 建堆
     *
     * @param data
     */
    private void buildHeap (int[] data) {
        //1 ~ n-1
        for (int i = 1; i < data.length; i++) {
            while (i / 2 > 0 && data[i] > data[i / 2]) {
                swap(data, i, i / 2);
                i = i / 2;
            }
        }
    }

    public static void main (String[] args) {
        // TODO: 2021/4/14 test
        int[] a = {0, 3, 2, 1, 5, 6, 7, 8, 9};
        HeapCopy2 heap = new HeapCopy2(a);
        heap.heapSort();
        heap.printData();
    }
}

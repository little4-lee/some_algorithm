package leetcode.tree;

import static common.ArrayUtilsKt.printArray;

public class HeapCopy3 {

    private final int[] data;

    public HeapCopy3 (int[] data) {
        this.data = data;
    }
    
    public void heapSort() {
        if (data == null) return;

        buildHeap(data);
        sort(data);
    }

    private void sort (int[] data) {
        int k = data.length - 1;
        while (k > 0) {
            swap(data, k, 1);
            k--;
            heaping(data, k, 1);
        }
    }

    private void heaping (int[] data, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && data[i * 2] > data[i]) maxPos = i * 2;
            if (i * 2 + 1 <= count && data[i * 2 + 1] > data[maxPos]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(data, maxPos, i);
            i = maxPos;
        }
    }

    private void swap (int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void buildHeap (int[] data) {
        for (int i = 0; i < data.length; i++) {
            while (i / 2 > 0 && data[i] > data[i / 2]) {
                swap(data, i, i / 2);
                i = i / 2;
            }
        }
    }

    public void printData() {
        printArray(data);
    }

    public static void main (String[] args) {
        int[] a = {0, 3, 2, 1, 5, 6, 7, 8, 9};
        HeapCopy3 heap = new HeapCopy3(a);
        heap.heapSort();
        heap.printData();
    }
}

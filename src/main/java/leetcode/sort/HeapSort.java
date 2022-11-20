package leetcode.sort;

import common.ListNode;

import static common.ArrayUtilsKt.swap;
import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

public class HeapSort {
    public static void main (String[] args) {
        ListNode list1 = arrayToList(1, 2, 3, 4, 5, 6, 7, 8, 10);
        ListNode list2 = arrayToList(10, 22, 33, 44, 55, 66, 77, 88,99);
        ListNode list3 = arrayToList(0, 0, 0, 0, 0);
        ListNode list4 = arrayToList(100, 100, 100, 100, 100, 100, 100, 100, 100);

        Heap heap = new Heap(list1, list2, list3, list4);
        ListNode list = heap.sort();
        printList(list);
    }
}

class Heap {
    private ListNode[] elements;
    private int count;

    public Heap (ListNode... args) {
        elements = new ListNode[args.length + 1];
        buildHeap(args);
    }

    public ListNode sort () {
        ListNode solder = new ListNode(1111);
        while (count > 0) {
            ListNode node = elements[1];
            elements[1] = null;
            if (node.next == null) {
                swap(elements, 1, count);
                count--;
            } else {
                elements[1] = node.next;
            }

            addToTail(solder, node);
            heaping(1);
        }
        return solder.next;
    }

    private void addToTail (ListNode head, ListNode tail) {
        tail.next = null;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = tail;
    }

    private void heaping (int index) {
        while (true) {
            int minPos = index;
            if (index * 2 <= count && elements[index * 2].value < elements[index].value)
                minPos = index * 2;
            if (index * 2 + 1 <= count && elements[index * 2 + 1].value < elements[minPos].value)
                minPos = index * 2 + 1;
            if (minPos == index) break;
            swap(elements, index, minPos);
            index = minPos;
        }
    }

    private void buildHeap (ListNode... args) {

        for (int i = 1; i < elements.length; i++) {
            //first index: 1
            elements[i] = args[i - 1];
        }

        for (int i = 2; i < elements.length; i++) {
            int index = i;
            while (index / 2 != 0 && elements[index].value < elements[index / 2].value) {
                swap(elements, index, index / 2);
                index = index / 2;
            }
        }
        count = args.length;
    }
}

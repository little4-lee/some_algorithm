package leetcode.sort

import common.printArray
import common.swap
import java.util.LinkedList
import javax.swing.text.Position

/**
 * @author: zhangjianfei03
 * @description:
 */

private fun test() {
    class BubbleSort : ISort {
        override fun sort(arr: IntArray?) {
            TODO()
        }
    }

    class InsertionSort : ISort {
        override fun sort(arr: IntArray?) {
            TODO()
        }
    }

    class SelectionSort : ISort {
        override fun sort(arr: IntArray?) {
            TODO()
        }
    }

    class QuickSort : ISort {
        override fun sort(arr: IntArray?) {
            // 检查边界
            if (arr == null || arr.isEmpty()) {
                return
            }
            doQuickSort(arr, 0, arr.lastIndex)
        }

        /**
         * 快排递归算法
         */
        private fun doQuickSort(arr: IntArray, start: Int, end: Int) {
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return
            }

            // 将arr分为两个区域，分别递归排序
            val partition = partition(arr, start, end)
            if (partition == -1) {
                return
            }
            doQuickSort(arr, start, partition - 1)
            doQuickSort(arr, partition + 1, end)
        }

        private fun partition(arr: IntArray, start: Int, end: Int): Int {
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return -1
            }

            val value = arr[end]
            // 分区游标
            var position = start
            // 遍历每一个元素，将小于value的值放在position的左边
            for (i in start until end) {
                if (arr[i] < value) {
                    //swap i position
                    swap(arr, i, position++)
                }
            }
            // swap position end
            swap(arr, position, end)
            return position
        }

        private fun swap(arr: IntArray, i: Int, j: Int) {
            if (i > arr.lastIndex || j > arr.lastIndex || i == j) {
                return
            }

            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    class HeapSort : ISort {
        override fun sort(arr: IntArray?) {
            if (arr == null || arr.isEmpty()) {
                return
            }
            // 建堆
            for (i in arr.size / 2 - 1 downTo 0) {
                heapify(arr, arr.lastIndex, i)
            }
            // 排序
            for (i in arr.lastIndex downTo 1) {
                swap(arr, i, 0)
                heapify(arr, i - 1, 0)
            }
        }

        private fun heapify(arr: IntArray, lastIndex: Int, heapifyPos: Int) {
            var pos = heapifyPos
            while (true) {
                var maxPos = pos
                val left = pos * 2 + 1
                val right = pos * 2 + 2
                if (left <= lastIndex && arr[left] > arr[maxPos]) maxPos = left
                if (right <= lastIndex && arr[right] > arr[maxPos]) maxPos = right
                if (maxPos == pos) break
                swap(arr, maxPos, pos)
                pos = maxPos
            }
        }
    }

    class MergeSort : ISort {
        override fun sort(arr: IntArray?) {
            if (arr == null || arr.isEmpty()) {
                return
            }
            doMergeSort(arr, 0, arr.lastIndex)
        }

        private fun doMergeSort(arr: IntArray, start: Int, end: Int) {
            if (start >= end) {
                return
            }
            val middle = start + (end - start) / 2
            doMergeSort(arr, start, middle)
            doMergeSort(arr, middle + 1, end)
            merge(arr, start, middle, end)
        }

        private fun merge(arr: IntArray, start: Int, middle: Int, end: Int) {
            val arrCopy = IntArray(end - start + 1)
            var indexCopy = 0

            var left = start
            var right = middle + 1

            while (left <= middle && right <= end) {
                if (arr[left] <= arr[right]) {
                    arrCopy[indexCopy++] = arr[left++]
                } else {
                    arrCopy[indexCopy++] = arr[right++]
                }
            }

            while (left <= middle) {
                arrCopy[indexCopy++] = arr[left++]
            }

            while (right <= end) {
                arrCopy[indexCopy++] = arr[right++]
            }

            arrCopy.forEachIndexed { index, value ->
                arr[start + index] = value
            }
        }
    }


    // test
    val arrList = arrayOf<IntArray?>(
        intArrayOf(2, 4, 5, 9, 5, 6, 6, 8, 3, 7),
        intArrayOf(1),
        intArrayOf(3, 2),
        intArrayOf(3, 2, 1),
        intArrayOf(2, 3),
        intArrayOf(),
        null
    )

    val sorts: MutableList<ISort> = LinkedList<ISort>()

//    sorts.add(BubbleSort())
//    sorts.add(InsertionSort())
//    sorts.add(SelectionSort())
//    sorts.add(QuickSort())
    sorts.add(HeapSort())
    sorts.add(MergeSort())
    for (sort in sorts) {
        println(sort.javaClass.getSimpleName() + " ==> ")
        for (arr in arrList) {
            val arrCopy = if (arr == null) null else arr.copyOf(arr.size)
            printArray(arrCopy)
            sort.sort(arrCopy)
            println()
            printArray(arrCopy)
            println()
            println("---------")
        }
    }
}

fun main() {
    test()
}

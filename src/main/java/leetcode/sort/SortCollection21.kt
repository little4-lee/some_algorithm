package leetcode.sort

import common.printArray
import common.swap
import java.util.LinkedList

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
            if (arr == null || arr.isEmpty()) {
                return
            }
            doQuickSort(arr, 0, arr.lastIndex)
        }

        /**
         * 快排递归函数
         */
        private fun doQuickSort(arr: IntArray, start: Int, end: Int) {
            if (start >= end) {
                return
            }
            // 找到分区点
            val partition = partitionFun(arr, start, end)
            // 对分区点两侧递归排序
            doQuickSort(arr, start, partition - 1)
            doQuickSort(arr, partition + 1, end)
        }

        /**
         * 快排分区函数
         */
        private fun partitionFun(arr: IntArray, start: Int, end: Int): Int {
            // 取末尾值value
            val value = arr[end]
            // 分区点游标
            var position = start
            // 找到比value小的所有点，移到分区点左边
            for (i in start until end) {
                if (arr[i] < value) {
                    // swap i position
                    swap(arr, i, position)
                    position++
                }
            }
            // 输出分区点
            swap(arr, position, end)
            return position
        }

        private fun swap(arr: IntArray, i: Int, j: Int) {
            if (i !in arr.indices || j !in arr.indices || i == j) {
                println("swap canceled for i=$i, j=$j, arr.size=${arr.size}")
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
                heaping(arr, arr.lastIndex, i)
            }

            // 排序：取堆顶元素，再堆化
            for (i in arr.lastIndex downTo 1) {
                // 取堆顶元素
                swap(arr, 0, i)
                // 堆化
                heaping(arr, i - 1, 0)
            }
        }

        /**
         *
         */
        private fun heaping(arr: IntArray, lastIndex: Int, i: Int) {
            var pos = i
            while (true) {
                var maxPos = pos
                val left = pos * 2 + 1
                val right = pos * 2 + 2
                if (left <= lastIndex && arr[left] > arr[maxPos]) maxPos = left
                if (right <= lastIndex && arr[right] > arr[maxPos]) maxPos = right
                if (maxPos == pos) break
                swap(arr, pos, maxPos)
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

        /**
         * 归并排序的递归函数
         */
        private fun doMergeSort(arr: IntArray, start: Int, end: Int) {
            if (start >= end) {
                return
            }
            val mid = start + (end - start) / 2
            doMergeSort(arr, start, mid)
            doMergeSort(arr, mid + 1, end)
            // 合并两个有序区间
            merge(arr, start, mid, end)
        }

        /**
         * 归并排序的合并函数
         */
        private fun merge(arr: IntArray, start: Int, mid: Int, end: Int) {
            val arrCopy = IntArray(end - start + 1)
            var indexCopy = 0

            var left = start
            var right = mid + 1
            while (left <= mid && right <= end) {
                if (arr[left] <= arr[right]) {
                    arrCopy[indexCopy++] = arr[left++]
                } else {
                    arrCopy[indexCopy++] = arr[right++]
                }
            }

            while (left <= mid) {
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
//    sorts.add(MergeSort())
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

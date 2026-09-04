package leetcode.sort

import common.printArray
import java.util.LinkedList
import javax.xml.stream.events.StartElement

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

        private fun doQuickSort(arr: IntArray, start: Int, end: Int) {
            // 边界检查
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return
            }

            // 将arr分区，再递归排序两个区域
            val partition = partitionFun(arr, start, end)
            if (partition == -1) {
                // 异常数据
                return
            }
            doQuickSort(arr, start, partition - 1)
            doQuickSort(arr, partition + 1, end)
        }

        private fun partitionFun(arr: IntArray, start: Int, end: Int): Int {
            // 边界检查
            if (start > arr.lastIndex || end > arr.lastIndex || start > end) {
                return -1
            }
            // 取最后一个值作为分区值
            val value = arr[end]
            // 分区游标
            var position = start
            // 遍历每一个值，寻找分区点
            for (i in start until end) {
                if (arr[i] < value) {
                    //swap i position
                    swap(arr, i, position++)
                }
            }
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
            TODO()
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
            //找到中点，分别排序
            val middle = start + (end - start) / 2
            doMergeSort(arr, start, middle)
            doMergeSort(arr, middle + 1, end)

            // 合并两个有序区间
            merge(arr, start, middle, end)
        }

        private fun merge(arr: IntArray, start: Int, middle: Int, end: Int) {
            //创建临时数组
            val arrCopy = IntArray(end - start + 1)
            var indexCopy = 0

            var indexLeft = start
            var indexRight = middle + 1

            while (indexLeft <= middle && indexRight <= end) {
                if (arr[indexLeft] <= arr[indexRight]) {
                    arrCopy[indexCopy++] = arr[indexLeft++]
                } else {
                    arrCopy[indexCopy++] = arr[indexRight++]
                }
            }

            while (indexLeft <= middle) {
                arrCopy[indexCopy++] = arr[indexLeft++]
            }

            while (indexRight <= end) {
                arrCopy[indexCopy++] = arr[indexRight++]
            }

            // 写回数据
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
//    sorts.add(HeapSort())
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

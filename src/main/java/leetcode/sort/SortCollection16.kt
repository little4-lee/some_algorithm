package leetcode.sort

import common.printArray
import java.awt.geom.Point2D
import java.util.LinkedList
import javax.imageio.metadata.IIOMetadataFormatImpl

/**
 * @author: zhangjianfei03
 * @description:
 */

private fun test() {
    class BubbleSort : ISort {
        override fun sort(arr: IntArray?) {
            // 检查边界
            if (arr == null || arr.isEmpty()) {
                return
            }
            for (i in arr.lastIndex downTo 1) {
                for (j in 1 .. i) {
                    if (arr[j-1] > arr[j]) {
                        val temp = arr[j-1]
                        arr[j-1] = arr[j]
                        arr[j] = temp
                    }
                }
            }
        }
    }

    class InsertionSort : ISort {
        override fun sort(arr: IntArray?) {
            // 边界检查
            if (arr == null || arr.isEmpty()) {
                return
            }
            for (i in 1 until arr.size) {
                // 每次循环把i插入到合适的位置
                val insertValue = arr[i]
                var insertIndex = -1
                for (j in i downTo 1) {
                    // arr[j] > value, 则交换，否则结束循环
                    if (arr[j-1] > insertValue) {
                        arr[j] = arr[j-1]
                        insertIndex = j - 1
                    } else {
                        break
                    }
                }
                // 插入数据
                if (insertIndex != -1) {
                    arr[insertIndex] = insertValue
                }
            }
        }
    }

    class SelectionSort : ISort {
        override fun sort(arr: IntArray?) {
            // 检查边界
            if (arr == null || arr.isEmpty()) {
                return
            }
            for (i in 0 until arr.lastIndex) {
                // 每次循环找到最小的值，插入i位置
                var minValue = arr[i]
                var minIndex = i
                for (j in i + 1 .. arr.lastIndex) {
                    // 找到最小的值
                    if (arr[j] < minValue) {
                        minValue = arr[j]
                        minIndex = j
                    }
                }
                if (minIndex != i) {
                    arr[minIndex] = arr[i]
                    arr[i] = minValue
                }
            }
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
         * 快速排序算法，递归执行
         */
        private fun doQuickSort(arr: IntArray, start: Int, end: Int) {
            // 检查边界
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return
            }
            // 找到分区点
            val partition = partition(arr, start, end)
            if (partition == -1) {
                // 异常数据
                return
            }
            doQuickSort(arr, start, partition - 1)
            doQuickSort(arr, partition + 1, end)
        }

        /**
         * 分区函数
         * - 返回分区点
         * - 分区完成后，分区点左边小于分支值，分区点右边大于等于分区值
         */
        private fun partition(arr: IntArray, start: Int, end: Int): Int {
            // 边界检查
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return -1
            }

            // 取最后一个作为分区值
            val value = arr[end]
            // 分区的游标
            var position = start
            // 循环：每次循环确定当前值与分区值的关系
            for (i in start until end) {
                if (arr[i] < value) {
                    // swap
                    swap(arr, i, position++)
                }
            }
            //swap position end
            swap(arr, position,end)
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
            // 边界检查
            if (arr == null || arr.isEmpty()) {
                return
            }
            doMergeSort(arr, 0, arr.lastIndex)
        }

        private fun doMergeSort(arr: IntArray, start: Int, end: Int) {
            // 边界检查
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return
            }

            // 分治排序
            val middle = start + (end - start) / 2
            doMergeSort(arr, start, middle)
            doMergeSort(arr, middle + 1, end)
            // 合并两个已排序区间
            merge(arr, start, middle, end)
        }

        private fun merge(arr: IntArray, start: Int, middle: Int, end: Int) {
            // 边界检查
            if (start > arr.lastIndex || middle > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return
            }

            var left = start
            var right = middle + 1

            val arrCopy = IntArray(end - start + 1)
            var indexCopy = 0
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

            // 写回原始数组
            for (i in 0 .. arrCopy.lastIndex) {
                arr[start+i] = arrCopy[i]
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
    sorts.add(QuickSort())
//    sorts.add(HeapSort())
//    sorts.add(MergeSort())
    for (sort in sorts) {
        println(sort.javaClass.getSimpleName() + " ==> ")
        for (arr in arrList) {
            val arrCopy = arr?.copyOf(arr.size)
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
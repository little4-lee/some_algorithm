package leetcode.sort

import common.printArray
import org.w3c.dom.DOMError
import java.util.LinkedList
import javax.sound.midi.MidiEvent
import kotlin.math.PI
import kotlin.math.min

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
            TODO()
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
//    sorts.add(QuickSort())
//    sorts.add(HeapSort())
    sorts.add(MergeSort())
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
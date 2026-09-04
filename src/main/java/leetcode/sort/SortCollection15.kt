package leetcode.sort

import algo._04stack.StackBasedOnArray
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
            // 边界检查
            if (arr == null || arr.isEmpty()) {
                return
            }

            for (i in arr.size - 1 downTo 0) {
                for (j in 1..i) {
                    if (arr[j] < arr[j - 1]) {
                        val temp = arr[j]
                        arr[j] = arr[j - 1]
                        arr[j - 1] = temp
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
                // 0..i-1 有序
                // i until arr.size 待排序
                // 待排序value
                val value = arr[i]
                var insertIndex = -1
                for (j in i downTo 1) {
                    // 把value插入合适的位置
                    if (arr[j - 1] > value) {
                        arr[j] = arr[j - 1]
                        insertIndex = j - 1
                    }
                }
                if (insertIndex != -1) {
                    arr[insertIndex] = value
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
            for (i in 0 until arr.size) {
                // 每次循环把最小的元素放入i位置
                val value = arr[i]
                var minIndex = i
                var minValue = value
                for (j in i + 1 until arr.size) {
                    // 每次循环找value最小元素的位置
                    if (arr[j] < minValue) {
                        minIndex = j
                        minValue = arr[j]
                    }
                }
                if (minIndex != i) {
                    arr[i] = minValue
                    arr[minIndex] = value
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
         * 递归方法：执行快速排序
         * @param arr 数组
         * @param start 开始位置
         * @param end 结束位置
         */
        private fun doQuickSort(arr: IntArray, start: Int, end: Int) {
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return
            }

            val partition = partition(arr, start, end)
            if (partition == -1) {
                // 异常值
                return
            }
            doQuickSort(arr, start, partition - 1)
            doQuickSort(arr, partition + 1, end)
        }

        /**
         * 分区函数
         * 返回分区的位置position，执行后position左边的元素都小于value，position右边的位置都大于等于value
         * @param arr 数组
         * @param start 开始位置
         * @param end 结束位置
         */
        private fun partition(arr: IntArray, start: Int, end: Int): Int {
            // 边界检查
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return -1
            }

            val value = arr[end]
            var position = start

            //循环：找出所有小于value的值，移动到数组的左边
            for (i in start .. end) {
                if (arr[i] < value) {
                    swap(arr, i, position++)
                }
            }
            //swap position end
            swap(arr, position, end)
            return position
        }

        private fun swap(arr: IntArray, i: Int, j: Int) {
            if (i > arr.lastIndex || j > arr.lastIndex) {
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

            mergeSort(arr, 0, arr.lastIndex)
        }

        private fun mergeSort(arr: IntArray, start: Int, end: Int) {
            // 边界检查
            if (start > arr.lastIndex || end > arr.lastIndex || start >= end) {
                return
            }
            val middle = (start + end) / 2
            mergeSort(arr, start, middle)
            mergeSort(arr, middle + 1, end)
            merge(arr, start, middle, end)
        }

        /**
         * 合并两个有序的空间
         * 将start..middle 和 middle + 1 .. end这两个有序空间合并
         */
        private fun merge(arr: IntArray, start: Int, middle: Int, end: Int) {
            // 边界检查
            if (start > arr.lastIndex || middle > arr.lastIndex || end > arr.lastIndex) {
                return
            }

            var left = start
            var right = middle + 1

            // 临时数组，用于合并后写入
            val arrayCopy = IntArray(end - start + 1)
            var indexCopy = 0
            while (left <= middle && right <= end) {
                if (arr[left] <= arr[right]) {
                    arrayCopy[indexCopy++] = arr[left++]
                } else {
                    arrayCopy[indexCopy++] = arr[right++]
                }
            }
            // 左边没合并完
            while (left <= middle) {
                arrayCopy[indexCopy++] = arr[left++]
            }

            // 右边没合并完
            while (right <= end) {
                arrayCopy[indexCopy++] = arr[right++]
            }

            // 复制回原来的数组
            for (i in 0 .. arrayCopy.lastIndex) {
                arr[start+i] = arrayCopy[i]
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

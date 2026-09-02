package leetcode.sort

import common.printArray
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
            TODO()
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

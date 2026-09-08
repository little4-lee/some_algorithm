package leetcode.search.binary_search

import common.printArray
import kotlin.math.PI

/**
 * @author: zhangjianfei03
 * @description:
 */

private fun test() {
    /**
     * just find target, ignore repeat
     */
    class BinarySearch : ISearch {
        override fun search(arr: IntArray?, target: Int): Int {
            if (arr == null || arr.isEmpty()) {
                return -1
            }

            var high = arr.lastIndex
            var low = 0
            var mid: Int
            while (low <= high) {
                mid = low + (high - low) / 2
                if (arr[mid] == target) {
                    return mid
                } else if (arr[mid] > target) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }

            return -1
        }
    }

    /**
     * find first target
     */
    class FindFirst : ISearch {
        override fun search(arr: IntArray?, target: Int): Int {
            if (arr == null || arr.isEmpty()) {
                return -1
            }

            var high = arr.lastIndex
            var low = 0
            var mid: Int
            while (low <= high) {
                mid = low + (high - low) / 2
                if (arr[mid] > target) {
                    high = mid - 1
                } else if (arr[mid] < target) {
                    low = mid + 1
                } else {
                    // equals
                    // 终止条件: 最左边元素 || mid-1 != target
                    if (mid == 0 || arr[mid-1] != target) {
                        return mid
                    } else {
                        high = mid - 1
                    }
                }
            }
            return -1
        }
    }


    /**
     * find last target
     */
    class FindLast : ISearch {
        override fun search(arr: IntArray?, target: Int): Int {
            if (arr == null || arr.isEmpty()) {
                return -1
            }

            var high = arr.lastIndex
            var low = 0
            var mid: Int

            while (low <= high) {
                mid = low + (high - low) / 2
                if (arr[mid] > target) {
                    high = mid - 1
                } else if (arr[mid] < target) {
                    low = mid + 1
                } else { // equals
                    // 结束条件：最右边元素 || 右边元素 != target
                    if (mid == arr.lastIndex || arr[mid + 1] != target) {
                        return mid
                    } else {
                        low = mid + 1
                    }
                }
            }
            return -1
        }
    }

    /**
     * find first not less than target
     */
    class FindFirstNotLessThan : ISearch {
        override fun search(arr: IntArray?, target: Int): Int {
            // >= target
            if (arr == null || arr.isEmpty()) {
                return -1
            }

            var high = arr.lastIndex
            var low = 0
            var mid: Int
            while (low <= high) {
                mid = low + (high - low) / 2
                if (arr[mid] >= target) {
                    // 结束条件: 1. 最左边元素 2. arr[mid-1] < target
                    if (mid == 0 || arr[mid - 1] < target) {
                        return mid
                    } else {
                        high = mid - 1
                    }
                } else {
                    low = mid + 1
                }
            }
            return -1
        }
    }

    /**
     * find last not more than target
     */
    class FindLastNotMoreThan : ISearch {
        override fun search(arr: IntArray?, target: Int): Int {
            // <= target
            if (arr == null || arr.isEmpty()) {
                return -1
            }

            var high = arr.lastIndex
            var low = 0
            var mid: Int

            while (low <= high) {
                mid = low + (high - low) / 2
                if (arr[mid] <= target) {
                    // 结束条件： 1. 最右边元素 2. mid + 1 > target
                    if (mid == arr.lastIndex || arr[mid + 1] > target) {
                        return mid
                    } else {
                        low = mid + 1
                    }
                } else {
                    high = mid - 1
                }
            }
            return -1
        }
    }

    val target = 5
    val count = 100
    val arr1 = IntArray(count)
    val arr2 = IntArray(count)
    val arr3 = intArrayOf(1, 2, 3, 4, target, target, target, target, 10, 20, 22, 50, 100, 102)
    val arr4 = intArrayOf(target, target + 1, target + 1, target + 1, target + 1, target + 1)
    val arr5 = intArrayOf(target - 1, target - 1, target - 1, target - 1, target - 1, target)
    val arr6 = intArrayOf(1, 2, 3, 4, 6, 7, 8, 9)

    for (i in 0 until count) {
        arr1[i] = i
        arr2[i] = target
    }
    val numArrayArray = arrayOf<IntArray?>(arr1, arr2, arr3, arr4, arr5, arr6)
    val searchArray = arrayOf<ISearch?>(
//        BinarySearch(),
//        FindFirst(),
//        FindLast(),
//        FindFirstNotLessThan(),
        FindLastNotMoreThan()
    )

    for (search in searchArray) {
        println("===>" + search!!.javaClass.getSimpleName())
        println("target: " + target)
        for (numArray in numArrayArray) {
            printArray(numArray)
            println("\nresult: " + search.search(numArray, target) + "\n")
        }
        println("----------------------")
    }
}

fun main() {
    test()
}
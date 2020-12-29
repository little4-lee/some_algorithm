package sort

import kotlin.math.pow
import kotlin.random.Random

private var COUNT = 100000
fun arr0() = arrayOf(1)
fun arr1() = arrayOf(3, 4, 6, 1, 8, 10, 100)

//fun arr2() = Array(COUNT) { it }
//fun arr3() = Array(COUNT) { COUNT - it }
//fun arr4() = Array(COUNT) { 1 }
fun arr5() = Array(COUNT) { Random.nextInt(0, COUNT) }

fun main() {
    repeat(4) {
        COUNT = 10.toFloat().pow(it + 3).toInt()
        println("count: $COUNT")
        exeSort(::bubbleSort, "BubbleSort")
        exeSort(::insertionSort, "InsertionSort")
        exeSort(::selectionSort, "SelectionSort")
        exeSort(::mergeSort, "MergeSort")
        exeSort(::quickSort, "QuickSort")
        println()
    }
}

fun exeSort(sort: (Array<Int>) -> Array<Int>, name: String) {
    val startTime = System.currentTimeMillis()
//    printArr(sort.invoke(arr0()))
//    printArr(sort.invoke(arr1()))
//    printArr(sort.invoke(arr2()))
//    printArr(sort.invoke(arr3()))
//    printArr(sort.invoke(arr4()))
//    printArr(sort.invoke(arr5()))

//    sort.invoke(arr0())
//    sort.invoke(arr1())
//    sort.invoke(arr2())
//    sort.invoke(arr3())
//    sort.invoke(arr4())
    sort.invoke(arr5())

    val endTime = System.currentTimeMillis()
    println("$name time: ${endTime - startTime} ms")
}

/**
 * 1. bubble sort
 * - time: O(n^2)
 * - space: O(1)
 * - in place: true
 * - stable: true
 *
 * @param arr
 */
private fun bubbleSort(arr: Array<Int>): Array<Int> {
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - i) {
            if (j == arr.size - 1) break
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j + 1]
                arr[j + 1] = arr[j]
                arr[j] = temp
            }
        }
    }
    return arr
}

/**
 * 2. insertion sort
 * - time: O(n^2)
 * - space: O(1)
 * - in place: true
 * - stable: true
 */
private fun insertionSort(arr: Array<Int>): Array<Int> {
    for (i in 1 until arr.size) {
        val value = arr[i]
        var index = i
        for (j in i - 1 downTo 0) {
            if (value < arr[j]) {
                arr[j + 1] = arr[j]
                index = j
            } else {
                index = j + 1
                break
            }
        }
        if (index != i) arr[index] = value
    }
    return arr
}

/**
 * 3. selection sort
 * - time: O(n^2)
 * - space: O(1)
 * - in place: true
 * - stable: true
 */
private fun selectionSort(arr: Array<Int>): Array<Int> {
    for (i in 0 until arr.size - 1) {
        var index = i

        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[index]) {
                index = j
            }
        }

        if (index != i) {
            val value = arr[i]
            arr[i] = arr[index]
            arr[index] = value
        }
    }
    return arr
}

/**
 * 4. merge sort
 * - time: O(n*log n)
 * - space: O(n)
 * - in place: false
 * - stable: true
 */
private fun mergeSort(arr: Array<Int>): Array<Int> {
    mergeSortInternal(arr, 0, arr.size - 1)
    return arr
}

private fun mergeSortInternal(arr: Array<Int>, start: Int, end: Int) {
    if (start == end) {
        return
    }

    val partition = start + (end - start) / 2
    mergeSortInternal(arr, start, partition)
    mergeSortInternal(arr, partition + 1, end)

    merge(arr, start, partition, partition + 1, end, start, end)
}

private fun merge(arr: Array<Int>, start1: Int, end1: Int, start2: Int, end2: Int, start: Int, end: Int) {
    var i1 = start1
    var i2 = start2

    val tmp = Array(end + 1 - start) { it }
    var i = 0

    while (i1 <= end1 && i2 <= end2) {
        if (arr[i1] <= arr[i2]) {
            tmp[i++] = arr[i1++]
        } else {
            tmp[i++] = arr[i2++]
        }
    }

    if (i1 <= end1) {
        while (i1 <= end1) {
            tmp[i++] = arr[i1++]
        }
    } else if (i2 <= end2) {
        while (i2 <= end2) {
            tmp[i++] = arr[i2++]
        }
    }

    for (item in 0 until tmp.size) {
        arr[start + item] = tmp[item]
    }
}

/**
 * 5. quick sort
 * - time: O(nlogn)
 * - space: O(1)
 * - in place: true
 * - stable: false
 */
private fun quickSort(arr: Array<Int>): Array<Int> {
    quickSortInternal(arr, 0, arr.size - 1)
    return arr
}

fun quickSortInternal(arr: Array<Int>, start: Int, end: Int) {
    if (start >= end) return

    val partition = partition(arr, start, end)

    quickSortInternal(arr, start, partition - 1)
    quickSortInternal(arr, partition + 1, end)
}

fun partition(arr: Array<Int>, start: Int, end: Int): Int {
    val value = arr[end]
    //partition
    var partition = start
    for (i in start until end) {
        if (arr[i] < value) {
            val tmp = arr[partition]
            arr[partition] = arr[i]
            arr[i] = tmp
            partition++
        }
    }

    arr[end] = arr[partition]
    arr[partition] = value

    return partition
}

private fun <T> printArr(arr: Array<T>) {
    for (item in arr) {
        print("$item  ")
    }
    println()
}
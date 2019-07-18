package _07sort

import _03linkedlist.SinglyLinkedList
import utils.randomArr
import kotlin.random.Random

fun main() {
    performanceContrast()
}

/**
 * 几种排序的性能测试
 */
fun performanceContrast() {
//    生成10000个数组
    var startTime = System.currentTimeMillis()
    for (i in 1..10000) {
        var arr = randomArr(Random.nextInt(100, 200))

//        bubbleSort(arr, arr.size)//100ms
//        insertionSort(arr, arr.size)//150ms
//        selectionSort(arr, arr.size)//250ms
//        mergeSort(arr, arr.size)
        quickSort(arr, arr.size)
    }
    var endTime = System.currentTimeMillis()
    println("sort: " + (endTime - startTime) + "ms")
}

fun testSortBaseOnLinkedList() {
    bubbleSort(SinglyLinkedList(randomArr(6)).head, 6)
}
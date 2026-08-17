package algo.utils

import common.ListNode
import javax.swing.plaf.ListUI
import kotlin.random.Random

//fun printArray(array: Array<Int?>?) {
//    if (array == null) println("array is empty")
//
//    for (index in array!!.indices) {
//        print("[" + index + "]" + array!![index] + " ")
//    }
//    println()
//}
//
//fun printLinkedList(head: ListNode?) {
//    if (head == null) println("list is empty")
//    var p = head
//    var index = 0
//    while (p != null) {
//        print("[" + index + "]" + p.value + " ")
//        p = p.next
//        index++
//    }
//    println()
//}
//
///**
// *
// */
//fun randomArr (length: Int): Array<Int?>{
//    var array = arrayOfNulls<Int>(length)
//
//    for (index in array.indices) {
//        array[index] = Random.nextInt(0,21)
//    }
//
//    return array
//}

fun <T> printLevelList(list: List<List<T?>?>?) {
    list ?: run {
        println("list is empty")
        return
    }

    list.forEachIndexed { index, list ->
        if (list == null) {
            println("$index level list is null")
        } else {
            println("$index level, items: ${list.joinToString(", ")}")
        }
    }
}

fun <T> printList(list: List<T?>?) {
    list ?: run {
        println("list is null")
        return
    }

    println("items: ${list.joinToString(", ")}")
}

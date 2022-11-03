package algo._07sort

import common.ListNode
import common.printLinkedList


/**
 * 冒泡排序(数组)
 */
fun bubbleSort(arr: Array<Int?>, n: Int) {
    if (n <= 1) return

    for (i in 0 until n - 1) {
        //表示数据交换的flag
        var flag = false
        for (j in 0 until n - i - 1) {
            if (arr[j]!! > arr[j + 1]!!) {
                var temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                flag = true
            }
        }
//        printArray(arr)
        //没有数据交换，退出循环
        if (!flag) break
    }
}

/**
 * 冒泡排序(链表)
 * - 原地(空间O(1))
 * - 稳定
 * - 时间复杂度：O(n^2)
 */
fun bubbleSort(head: ListNode?, n: Int): ListNode? {
    if (n <= 1 || head == null) return null

    var soldier = ListNode(-1)
    soldier.next = head
    var pre: ListNode?
    var p: ListNode?

    for (i in 0 until n - 1) {
        pre = soldier
        p = soldier.next
        var flag = false
        while (p?.next != null) {
            if (p.value > p!!.next!!.value) {

                var pNext = p.next!!.next
                p!!.next!!.next = p
                pre?.next = p.next
                pre = p.next!!
                p.next = pNext

                flag = true
            } else {
                pre = p
                p = p.next
            }
        }
        printLinkedList(soldier.next)
        if (!flag) break
    }

    return soldier.next
}

/**
 * 插入排序(数组)
 */
fun insertionSort(arr: Array<Int?>, n: Int) {
    if (n <= 1) return

    for (i in 1 until n) {
        var j = i - 1
        var value = arr[i]
        while (j >= 0) {
            if (arr[j]!! > value!!) {
                arr[j + 1] = arr[j]
                j--
            } else {
                break
            }
        }
        arr[j + 1] = value
//        printArray(arr)
    }
}

/**
 * 插入排序(链表)
 */
fun insertionSort(head: ListNode?): ListNode? {

    TODO()
}

/**
 * 选择排序(数组)
 */
fun selectionSort(arr: Array<Int?>, n: Int) {

    for (i in 0..n - 1) {
        var minIndex = i
        for (j in i..n - 1) {
            if (arr[j]!! < arr[minIndex]!!) {
                minIndex = j
            }
        }

        var tmp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = tmp
//        printArray(arr)
    }
}

/**
 * 选择排序(链表)
 */
fun selectionSort(head: ListNode?): ListNode? {
    TODO()
}
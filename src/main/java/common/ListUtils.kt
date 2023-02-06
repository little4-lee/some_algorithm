package common

import kotlin.random.Random

fun arrayToList(vararg array: Int): ListNode? {
    var head: ListNode? = null
    var temp: ListNode? = null
    var pre: ListNode? = null
    for (i in array.indices) {
        temp = ListNode(array[i])
        if (i == 0) {
            head = temp
        } else {
            pre!!.next = temp
        }
        pre = temp
    }
    return head
}


fun addCycle(head: ListNode?, index: Int): ListNode? {
    if (head == null || index < 0) return head
    var curIndex = 0
    var p: ListNode = head
    var cycleStart: ListNode? = null
    while (p.next != null) {
        if (curIndex == index) cycleStart = p
        p = p.next
        curIndex++
    }
    //p is the end of the list
    p.next = cycleStart
    return head
}


fun addTail(original: ListNode?, tail: ListNode?) {
    if (original == null || tail == null) return
    var p: ListNode = original
    while (p.next != null) {
        p = p.next
    }
    p.next = tail
}


fun printList(head: ListNode?) {
    if (head == null) println("empty list")
    var p = head
    while (p != null) {
        println(p.value)
        p = p.next
    }
}

fun printListInLine(head: ListNode?) {
    if (head == null) println("empty list")
    var p = head
    while (p != null) {
        print("${p.value} ")
        p = p.next
    }
}

fun printLinkedList(head: ListNode?) {
    if (head == null) println("list is empty")
    var p = head
    var index = 0
    while (p != null) {
        print("[" + index + "]" + p.value + " ")
        p = p.next
        index++
    }
    println()
}

/**
 *
 */
fun randomArr (length: Int): Array<Int?>{
    var array = arrayOfNulls<Int>(length)

    for (index in array.indices) {
        array[index] = Random.nextInt(0,21)
    }

    return array
}

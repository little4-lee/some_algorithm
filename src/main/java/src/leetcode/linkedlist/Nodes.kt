package leetcode.linkedlist

import common.ListNode

//fun printList(head: ListNode?) {
//    if (head == null) println("empty list")
//
//    var p = head
//    while (p != null) {
//        println(p.value)
//        p = p.next
//    }
//}
//
//fun arrayToList(vararg array: Int): ListNode? {
//    var head: ListNode? = null
//    var temp: ListNode? = null
//    var pre: ListNode? = null
//    for (i in array.indices) {
//        temp = ListNode(array[i])
//        if (i == 0) {
//            head = temp
//        } else {
//            pre!!.next = temp
//        }
//        pre = temp
//    }
//
//    return head
//}
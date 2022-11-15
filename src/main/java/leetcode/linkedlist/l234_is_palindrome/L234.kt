package linkedlist

import common.ListNode
import common.arrayToList

fun isPalindrome(head: ListNode?): Boolean {
    head ?: return true
    head.next ?: return true

    val flag = ListNode(-1000)

    var fast = head
    var slow = head
    var slowNext: ListNode?

    while (fast?.next?.next != null) {
        fast = fast.next.next
        slowNext = slow!!.next

        slow.next = flag.next
        flag.next = slow
        slow = slowNext
    }

    return if (fast!!.next == null) {
        //odd len
        theSameLinkedList(slow!!.next, flag.next)
    } else {
        //even len
        slowNext = slow!!.next
        slow.next = flag.next
        flag.next = slow

        theSameLinkedList(slowNext, flag.next)
    }
}

fun theSameLinkedList(first: ListNode, second: ListNode): Boolean {
    var f: ListNode? = first
    var s: ListNode? = second
    while (f != null && s != null) {
        if (f.value == s.value) {
            f = f.next
            s = s.next
            continue
        }
        return false
    }
    return true
}

fun main() {
    println(isPalindrome(arrayToList(1, 2)))
    println(isPalindrome(arrayToList(1, 2, 1)))
    println(isPalindrome(arrayToList(1, 2, 2, 1)))
    println(isPalindrome(arrayToList(1, 2, 3, 3, 2, 1)))
    println(isPalindrome(arrayToList(1)))
    println(isPalindrome(arrayToList()))
}
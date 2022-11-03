package linkedlist

fun isPalindrome(head: _root_ide_package_.leetcode.linkedlist.ListNode?): Boolean {
    head ?: return true
    head.next ?: return true

    val flag = _root_ide_package_.leetcode.linkedlist.ListNode(-1000)

    var fast = head
    var slow = head
    var slowNext: _root_ide_package_.leetcode.linkedlist.ListNode?

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

fun theSameLinkedList(first: _root_ide_package_.leetcode.linkedlist.ListNode, second: _root_ide_package_.leetcode.linkedlist.ListNode): Boolean {
    var f: _root_ide_package_.leetcode.linkedlist.ListNode? = first
    var s: _root_ide_package_.leetcode.linkedlist.ListNode? = second
    while (f != null && s != null) {
        if (f.`val` == s.`val`) {
            f = f.next
            s = s.next
            continue
        }
        return false
    }
    return true
}

fun main() {
    println(isPalindrome(_root_ide_package_.leetcode.linkedlist.NodeUtils.arrayToList(1, 2)))
    println(isPalindrome(_root_ide_package_.leetcode.linkedlist.NodeUtils.arrayToList(1, 2, 1)))
    println(isPalindrome(_root_ide_package_.leetcode.linkedlist.NodeUtils.arrayToList(1, 2, 2, 1)))
    println(isPalindrome(_root_ide_package_.leetcode.linkedlist.NodeUtils.arrayToList(1, 2, 3, 3, 2, 1)))
    println(isPalindrome(_root_ide_package_.leetcode.linkedlist.NodeUtils.arrayToList(1)))
    println(isPalindrome(_root_ide_package_.leetcode.linkedlist.NodeUtils.arrayToList()))
}
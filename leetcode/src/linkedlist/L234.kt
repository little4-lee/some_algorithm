package linkedlist

fun isPalindrome(head: ListNode?): Boolean {
    var fast = head
    var slow = head
    var so:ListNode? = null
    var preSo:ListNode? = null

    while (fast?.next?.next != null) {
        fast = fast.next.next
        preSo = so
        so = slow
        slow = slow!!.next
        so!!.next = preSo
    }

    return if (fast!!.next == null) {
        //奇数
        slow = slow!!.next
        theSameLinkedList(slow, so!!)
    } else {
        //偶数
        preSo = so
        so = slow
        slow = slow!!.next
        so!!.next = preSo
        theSameLinkedList(slow, so)
    }
}

fun theSameLinkedList(first: ListNode, second: ListNode): Boolean {
    var f = first
    var s = second
    while (f.next != null && s.next != null) {
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
    val node = NodeUtils.arrayToList(1,2)
    println(isPalindrome(node))
}
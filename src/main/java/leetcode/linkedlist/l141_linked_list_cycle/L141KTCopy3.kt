package leetcode.linkedlist.l141_linked_list_cycle

import common.ListNode
import common.addCycle
import common.arrayToList

class L141KTCopy3 {
    fun hasCycle(head: ListNode?): Boolean {
        head ?: return false

        var slow = head
        var fast = head.next

        while (fast?.next != null) {
            if (slow === fast) return true
            slow = slow?.next
            fast = fast.next.next
        }
        return false
    }
}

fun main() {
    println(L141KTCopy3().hasCycle(arrayToList(1, 2, 3, 4, 5, 6, 7)))
    println(L141KTCopy3().hasCycle(arrayToList(1, 2, 3, 4, 5, 6, 7).apply {
        addCycle(this, 4)
    }))
    println(L141KTCopy3().hasCycle(arrayToList(1)))
    println(L141KTCopy3().hasCycle(null))
}
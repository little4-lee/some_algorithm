package leetcode.linkedlist.l142_linked_list_cycle_2

import common.ListNode
import common.addCycle
import common.arrayToList
import leetcode.linkedlist.l141_linked_list_cycle.L141KTCopy2

class L142KTCopy1 {
    fun detectCycle(head: ListNode?): ListNode? {
        head ?: return null
        head.next ?: return null

        var slow = head.next
        var fast = head.next.next

        while (fast?.next != null) {
            if (slow === fast) {
                break
            }
            slow = slow?.next
            fast = fast.next.next
        }

        // 无环
        if (slow != fast) {
            return null
        }

        var cur = head
        while (cur != slow) {
            cur = cur?.next
            slow = slow?.next
        }
        return cur
    }
}

fun main() {
    println(L142KTCopy1().detectCycle(arrayToList(1, 2, 3, 4, 5, 6, 7)))
    println(L142KTCopy1().detectCycle(arrayToList(1, 2, 3, 4, 5, 6, 7).apply {
        addCycle(this, 0)
    }))
    println(L142KTCopy1().detectCycle(arrayToList(1)))
    println(L142KTCopy1().detectCycle(null))
}
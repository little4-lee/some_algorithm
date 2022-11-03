package leetcode.linkedlist.l142_linked_list_cycle_2

import leetcode.linkedlist.ListNode
import leetcode.linkedlist.NodeUtils
import leetcode.linkedlist.NodeUtils.arrayToList

class L142KT {
    fun detectCycle(head: _root_ide_package_.leetcode.linkedlist.ListNode?): _root_ide_package_.leetcode.linkedlist.ListNode? {
        head ?: return null
        head.next ?: return null

        var slow = head.next
        var fast = head.next.next
        //detect cycle
        while (fast?.next != null) {
            if (slow == fast) break
            slow = slow.next
            fast = fast.next.next
        }

        if (slow != fast) return null

        //get cycle node
        var p = head
        while (p != slow) {
            p = p?.next
            slow = slow.next
        }
        return p
    }
}

fun main() {
    val list = arrayToList(1, 2, 3, 4, 5, 6, 7)
    _root_ide_package_.leetcode.linkedlist.NodeUtils.addCycle(list, 1)
    println(L142KT().detectCycle(list)?.`val`)
}
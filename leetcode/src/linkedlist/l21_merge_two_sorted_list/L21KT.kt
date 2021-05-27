package linkedlist.l21_merge_two_sorted_list

import linkedlist.ListNode
import linkedlist.NodeUtils

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
class L21KT {
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val soldier = ListNode(1000)
    var p = soldier
    var p1 = l1
    var p2 = l2

    while (p1 != null && p2 != null) {
        if (p1.`val` < p2.`val`) {
            p.next = p1
            p = p1
            p1 = p1.next
        } else {
            p.next = p2
            p = p2
            p2 = p2.next
        }
    }

    if (p1 == null) {
        p.next = p2
    }

    if (p2 == null) {
        p.next = p1
    }

    return soldier.next
}

fun main() {
    val a1 = NodeUtils.arrayToList(1, 2, 3, 4, 10, 100)
    val a2 = NodeUtils.arrayToList(2, 2, 2, 4, 4, 101)
    NodeUtils.printList(mergeTwoLists(a1, a2))
}
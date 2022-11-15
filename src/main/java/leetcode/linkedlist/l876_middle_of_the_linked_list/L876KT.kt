package linkedlist

import common.ListNode
import common.arrayToList
import common.printList

/**
 * 876. Middle of the Linked List
 *
 * Given a non-empty, singly linked list with head node head,
 * return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 */

fun main() {
//    val node = NodeUtils.arrayToList(1, 2, 6, 3, 4, 5, 1, 2, 6, 3, 4, 5)
//    val node = NodeUtils.arrayToList(1, 2, 6, 3, 4, 5)
    val node = arrayToList(1, 2, 3)
//    val node = NodeUtils.arrayToList(1, 2)
//    val node = NodeUtils.arrayToList(1)
    printList(middleNode(node))
}

fun middleNode(head: ListNode?): ListNode? {
    if (head == null) return null

    var fast = head
    var slow = head

    while (fast?.next != null && fast.next.next != null) {
        fast = fast.next.next
        slow = slow?.next
    }

    return if (fast?.next == null) slow
    else slow?.next
}
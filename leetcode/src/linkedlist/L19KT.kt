package linkedlist

/**
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 * Follow up: Could you do this in one pass?
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 */

fun main() {
//    printList(removeNthFromEnd(arrayToList(1, 2, 3, 4, 5), 2))
//    printList(removeNthFromEnd(arrayToList(1, 2, 3), 2))
    printList(removeNthFromEnd(arrayToList(1, 2), 2))
//    printList(removeNthFromEnd(arrayToList(1, 2), 1))
//    printList(removeNthFromEnd(arrayToList(1), 2))
//    printList(removeNthFromEnd(arrayToList(1), 1))
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    head ?: return head

    val soldier = ListNode(0)
    soldier.next = head

    var index = 1
    var fast = soldier.next
    var slow = soldier
    while (index < n && fast.next != null) {
        fast = fast.next
        index++
    }

    if (index < n) {
        //链表长度小于n
        return soldier.next
    }

    while (fast.next != null) {
        fast = fast.next
        slow = slow.next
    }

    //remove node: slow.next
    val temp = slow.next
    slow.next = slow.next.next
    temp.next = null

    return soldier.next
}
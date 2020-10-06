package linkedlist

fun reverseBetween(head: ListNode?, start: Int, end: Int) : ListNode?{
    if (head == null) return null
    if (start == end) return head

    val soldier = ListNode(-1000)
    var preStart = head
    var p = head
    var index = 1

    var pNext: ListNode?
    while (p != null && index <= end) {
        pNext = p.next

        if (index == start - 1) {
            preStart = p
        }

        if (index >= start) {

        }

        index++
        p = pNext
    }

    return soldier.next
}
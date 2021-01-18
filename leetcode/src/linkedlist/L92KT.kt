package linkedlist

class L92KT {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        val soldier = ListNode(0)
        soldier.next = head
        var p = head
        var start: ListNode? = null
        var preStart: ListNode? = soldier
        var index = 1

        while (p != null && index <= n) {
            val pNext = p.next

            if (index == m - 1) {
                preStart = p
            } else if (index >= m) {
                if (index == m) start = p
                p.next = preStart?.next
                preStart?.next = p
            }
            p = pNext
            index++
        }
        start?.next = p
        return soldier.next
    }
}

fun main() {
    val list = arrayToList(1, 2, 3, 4, 5, 6, 7)
//    printList(L92KT().reverseBetween(list, 1, 7))
    printList(L92KT().reverseBetween(list, 5, 7))
//    printList(L92KT().reverseBetween(list, 1, 5))
//    printList(L92KT().reverseBetween(list, 2, 5))
}
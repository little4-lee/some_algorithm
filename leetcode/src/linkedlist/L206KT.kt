package linkedlist

class L206KT {
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null

        val soldier = ListNode(0)
        var p = head

        while (p != null) {
            val next = p.next
            p.next = soldier.next
            soldier.next = p
            p = next
        }

        return soldier.next
    }
}

fun main() {
//    val list = arrayToList(1, 2, 3, 4, 5, 6, 7)
//    val list = arrayToList(1)
    val list = arrayToList()
    printList(L206KT().reverseList(list))
}
package linkedlist

class L141KT {
    fun hasCycle(head: ListNode?): Boolean {
        head ?: return false

        var slow = head
        var quick = head.next

        while (quick?.next != null) {
            if (slow == quick) return true
            slow = slow?.next
            quick = quick.next.next
        }

        return false
    }
}

fun main() {
    val list = arrayToList(1, 2, 3, 4, 5, 6, 7)
//    NodeUtils.addCycle(list, 4)
    println(L141KT().hasCycle(list))
}
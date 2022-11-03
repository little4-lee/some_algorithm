package leetcode.linkedlist

fun printList(head: _root_ide_package_.leetcode.linkedlist.ListNode?) {
    if (head == null) println("empty list")

    var p = head
    while (p != null) {
        println(p.`val`)
        p = p.next
    }
}

fun arrayToList(vararg array: Int): _root_ide_package_.leetcode.linkedlist.ListNode? {
    var head: _root_ide_package_.leetcode.linkedlist.ListNode? = null
    var temp: _root_ide_package_.leetcode.linkedlist.ListNode? = null
    var pre: _root_ide_package_.leetcode.linkedlist.ListNode? = null
    for (i in array.indices) {
        temp = _root_ide_package_.leetcode.linkedlist.ListNode(array[i])
        if (i == 0) {
            head = temp
        } else {
            pre!!.next = temp
        }
        pre = temp
    }

    return head
}
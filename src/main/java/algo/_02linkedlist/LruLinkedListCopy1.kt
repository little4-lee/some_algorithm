package algo._02linkedlist

import common.ListNode
import common.printList

/**
 * @description:
 * 1. 查询：队列中存在则删除（删除length -1）
 * 2. 插入：添加到head(添加 length+1)
 */

class LruLinkedListCopy1 {

    private companion object {
        private const val MAX_LENGTH: Int = 10
    }

    private var head: ListNode? = null
    private var length = 0

    // lru add logic
    fun add(node: ListNode) {
        // find node
        if (findAndDelete(node.value)) {
            addToHead(node)
            return
        }
        // not found
        if (length == MAX_LENGTH) {
            removeTail()
        }
        addToHead(node)
    }

    private fun findAndDelete(targetValue: Int): Boolean {
        // head == null
        // head == node.value
        // found multiple node

        val sentinel = ListNode(0)
        sentinel.next = head

        var pre = sentinel
        var cur = sentinel.next
        var deleted = false

        while (cur != null) {
            if (cur.value == targetValue) {
                // 删除节点
                pre.next = cur.next
                cur.next = null
                cur = pre.next
                length--
                deleted = true
                continue
            }
            pre = pre.next
            cur = cur.next
        }

        head = sentinel.next
        return deleted
    }

    private fun addToHead(node: ListNode) {
        node.next = head
        head = node
        length++
    }

    private fun removeTail(): ListNode? {
        // head == null
        // head == tail

        val sentinel = ListNode(0)
        sentinel.next = head

        var pre = sentinel
        var cur = sentinel.next

        var deleted: ListNode? = null

        while (cur != null) {
            if (cur.next == null) {
                deleted = cur
                pre.next = null
                cur = null
                length--
                break
            }
            pre = pre.next
            cur = cur.next
        }

        head = sentinel.next
        return deleted
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    fun getList(): ListNode? {
        return head
    }

    fun main() {


//        for (int i = 0; i <= 7; i++) {
//            list.addToHead(new ListNode(i));
//            printList(list.getList());
//            System.out.println();
//        }
    }
}

fun main() {
    val list = LruLinkedListCopy1()
    for (i in 8 downTo 0) {
        list.add(ListNode(i))
    }

    println("default: ")
    printList(list.getList())
    println()
    println()
    println()
    println()

    for (i in 0..19) {
        println("add: " + i)
        list.add(ListNode(i))
        printList(list.getList())
        println()
    }
}
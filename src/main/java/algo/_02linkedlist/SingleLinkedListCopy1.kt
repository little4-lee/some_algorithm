package algo._02linkedlist

import common.ListNode
import common.arrayToList
import common.printListInLine
import java.awt.Cursor
import java.awt.image.ShortLookupTable
import kotlin.math.sin

/**
 * @author: zhangjianfei03
 * @description:
 */
class SingleLinkedListCopy1(var head: ListNode? = null) {

    fun findByValue(value: Int): ListNode? {
        var cur = head
        while (cur != null) {
            if (cur.value == value) return cur
            cur = cur.next
        }
        return null
    }

    fun findByIndex(index: Int): ListNode? {
        if (index < 0) return null

        var cur = head
        var curIndex = 0
        while (cur != null && curIndex < index) {
            curIndex++
            cur = cur.next
        }
        return cur
    }

    /**
     * 在链表头部插入值为value的节点
     *
     * @param value
     */
    fun insertToHead(value: Int) {
        // head == null
        // 1. 不使用solder
        val newNode = ListNode(value)
        newNode.next = head
        head = newNode
        // 2. 使用solder
//        val solder = ListNode(0)
//        solder.next = head
//        val newNode = ListNode(value)
//        newNode.next = solder.next
//        solder.next = newNode
//        head = solder.next
    }

    /**
     * 在链表头部插入节点newNode
     *
     * @param newNode
     */
    fun insertToHead(newNode: ListNode) {
        // 不使用sentinel
//        newNode.next = head
//        head = newNode
//
        // 使用sentinel
        val sentinel = ListNode(0)
        sentinel.next = head
        newNode.next = sentinel.next
        sentinel.next = newNode
        head = sentinel.next
    }

    /**
     * 在链表尾部插入值为value的节点
     *
     * @param value
     */
    fun insertToTail(value: Int) {
//        val newNode = ListNode(value)
//        if (head == null) {
//            head = newNode
//            return
//        }
//        var cur = head
//        while (cur?.next != null) {
//            cur = cur.next
//        }
//        cur?.next = newNode

        // sentinel
        val sentinel = ListNode(0)
        sentinel.next = head
        val toInsertNode = ListNode(value)

        var cur = sentinel
        while (cur.next != null) {
            cur = cur.next
        }
        cur.next = toInsertNode
        head = sentinel.next
    }

    /**
     * 在链表尾部插入节点newNode
     *
     * @param newNode
     */
    fun insertToTail(newNode: ListNode) {
        // no sentinel
//        if (head == null) {
//            head = newNode
//            return
//        }
//
//        var cur = head
//        while (cur?.next != null) {
//            cur = cur.next
//        }
//        cur?.next = newNode

        // sentinel
        // 哨兵节点
        val sentinel = ListNode(0)
        sentinel.next = head

        var cur = sentinel
        while (cur.next != null) {
            cur = cur.next
        }
        cur.next = newNode
        head = sentinel.next
    }


    /**
     * 在节点P后插入值为value的节点
     *
     * @param p
     * @param value
     */
    fun insertAfter(p: ListNode?, value: Int) {
        p ?: return

        // 哨兵节点
        val sentinel = ListNode(0)
        sentinel.next = head

        val toInsert = ListNode(value)
        var cur = sentinel.next
        while (cur != null) {
            if (cur === p) {
                // 找到了节点, 插入
                toInsert.next = cur.next
                cur.next = toInsert
                break
            }
            cur = cur.next
        }
        head = sentinel.next
    }
    /**
     * 在value为p的节点后插入值为value的节点
     *
     * @param p
     * @param value
     */
    fun insertAfter(p: Int, value: Int) {
        // no sentinel
        if (head == null) return
        var cur = head
        while (cur != null) {
            if (cur.value == p) {
                val newNode = ListNode(value)
                newNode.next = cur.next
                cur.next = newNode
                break
            }
            cur = cur.next
        }


        // 哨兵节点
//        val sentinel = ListNode(0)
//        sentinel.next = head
//
//        val toInsert = ListNode(value)
//        var cur = sentinel.next
//        while (cur != null) {
//            if (cur.value == p) {
//                // 找到了节点, 插入
//                toInsert.next = cur.next
//                cur.next = toInsert
//                break
//            }
//            cur = cur.next
//        }
//        head = sentinel.next
    }

    /**
     * 在节点P后插入新节点newNode
     *
     * @param p
     * @param newNode
     */
    fun insertAfter(p: ListNode?, newNode: ListNode) {

    }

    /**
     * 在value wei为p的节点之前插入值为value的节点
     *
     * @param targetValue
     * @param value
     */
    fun insertBefore(targetValue: Int, value: Int) {
        // head == null
        // p == head.value
        // p 未找到
        // p 找到1个
        // p 有多个
        val sentinel = ListNode(0)
        sentinel.next = head

        var pre = sentinel
        var cur = sentinel.next
        while (cur != null) {
            if (cur.value == targetValue) {
                // 找到目标节点
                val toInsert = ListNode(value)
                toInsert.next = cur
                pre.next = toInsert
                break
            }
            pre = pre.next
            cur = cur.next
        }

        head = sentinel.next
    }

    /**
     * 在节点p之前插入节点newNode
     *
     * @param p
     * @param newNode
     */
    fun insertBefore(p: ListNode?, newNode: ListNode) {
        TODO()
    }

    /**
     * 删除链表中**第一个**值为value的节点
     *
     * @param value
     */
    fun deleteFirstByValue(value: Int) {
        // 哨兵节点
        val sentinel = ListNode(0)
        sentinel.next = head

        var pre = sentinel
        var cur = sentinel.next
        while (cur != null) {
            if (cur.value == value) {
                // 删除cur节点-进删除一个
                pre.next = cur.next
                cur.next = null
                break
            }
            pre = pre.next
            cur = cur.next
        }

        head = sentinel.next
    }

    /**
     * 删除链表中**所有**值为value的节点
     *
     * @param value
     */
    fun deleteAllByValue(value: Int) {
        // head == null
        // value 不存在
        // value 存在多个

        val sentinel = ListNode(0)
        sentinel.next = head

        var pre = sentinel
        var cur = sentinel.next
        while (cur != null) {
            if (cur.value == value) {
                // 删除cur节点
                val curNext = cur.next
                pre.next = curNext
                // cur指向下一个节点
                cur.next = null
                cur = curNext
                continue
            }
            pre = pre.next
            cur = cur.next
        }

        head = sentinel.next
    }

    /**
     * 删除链表中值为value的节点
     *
     * @param value
     * @param delAll true: 删除所有值为value的节点 false: 删除第一个值为value的节点
     */
    fun deleteByValue(value: Int, delAll: Boolean) {
        // head == null
        // head.value == value
        // value 不存在
        // value 有多个

        val sentinel = ListNode(0)
        sentinel.next = head

        var pre = sentinel
        var cur = sentinel.next

        while (cur != null) {
            if (cur.value == value) {
                // 找到节点
                // 删除cur
                val curNext = cur.next
                cur.next = null
                pre.next = curNext
                // 是否删除全部
                if (delAll) {
                    cur = curNext
                    continue
                } else {
                    break
                }
            }
            pre = pre.next
            cur = cur.next
        }

        head = sentinel.next
    }

    /**
     * 删除节点delNode
     *
     * @param delNode
     */
    fun deleteByNode(delNode: ListNode?) {
        TODO()
    }

    override fun toString(): String {

        return super.toString()
    }
}

fun main() {
    val list1 = SingleLinkedListCopy1(null)
    val list2 = SingleLinkedListCopy1(arrayToList(1))
    val list3 = SingleLinkedListCopy1(arrayToList(1,2,3,3,4))

    // test find by value
//    println("test findByValue")
//    println(list1.findByValue(2))
//    println(list2.findByValue(2))
//    println(list3.findByValue(2))
//    println()

//    println("test findByIndex")
//    println(list1.findByIndex(0))
//    println(list2.findByIndex(0))
//    println(list3.findByIndex(0))
//    println()

//    println("test insertToHead-value")
//    list1.insertToHead(1)
//    list2.insertToHead(1)
//    list3.insertToHead(1)
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

//    println("test insertToHead-node")
//    list1.insertToHead(ListNode(1))
//    list2.insertToHead(ListNode(1))
//    list3.insertToHead(ListNode(1))
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

//    println("test insertToTail-value")
//    list1.insertToTail(9)
//    list2.insertToTail(9)
//    list3.insertToTail(9)
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

//    println("test insertToTail-node")
//    list1.insertToTail(ListNode(1))
//    list2.insertToTail(ListNode(1))
//    list3.insertToTail(ListNode(1))
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

//    val node1 = ListNode(-1)
//    val node2 = ListNode(-2)
//    val node3 = ListNode(-3)
//    println("test insertAfter-value")
//    list1.insertToHead(node1)
//    list2.insertToTail(node2)
//    list2.insertToTail(2)
//    list3.insertToTail(node3)
//
//    list1.insertAfter(100, -2)
//    list2.insertAfter(-2, -3)
//    list3.insertAfter(3, -4)
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

//    println("test insertBefore-value")
//    list1.insertBefore(1, -2)
//    list2.insertBefore(1, -3)
//    list3.insertBefore(3, -4)
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

//    println("test deleteFirstByValue-value")
//    list1.deleteFirstByValue(1)
//    list2.deleteFirstByValue(1)
//    list3.deleteFirstByValue(3)
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

//    println("test deleteAllByValue-value")
//    list1.deleteAllByValue(1)
//    list2.deleteAllByValue(1)
//    list3.deleteAllByValue(3)
//    printListInLine(list1.head)
//    println()
//    printListInLine(list2.head)
//    println()
//    printListInLine(list3.head)
//    println()
//    println()

    println("test deleteAllByValue-value")
    list1.deleteByValue(1, true)
    list2.deleteByValue(1, false)
    list3.deleteByValue(3, true)
    printListInLine(list1.head)
    println()
    printListInLine(list2.head)
    println()
    printListInLine(list3.head)
    println()
    println()

}
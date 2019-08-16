package _03linkedlist

import utils.Node

class SinglyLinkedList {

    var head: Node? = null

    constructor(array: IntArray) {

        for (v in array) {
            insertToTail(v)
        }
    }

    constructor(array: Array<Int?>) {
        for (v in array) {
            insertToTail(v!!)
        }
    }

    /**
     * 在链表尾部插入值为value的节点
     *
     * @param value
     */
    fun insertToTail(value: Int) {
        val newNode = Node(value)
        insertToTail(newNode)
    }

    /**
     * 在链表尾部插入节点newNode
     *
     * @param newNode
     */
    fun insertToTail(newNode: Node) {

        if (head == null) {
            head = newNode
        } else {
            var q = head

            while (q?.next != null) {
                q = q.next
            }
            newNode.next = q?.next
            q?.next = newNode
        }
    }

    fun print () {

        var content = ""
        var p = head
        while (p != null) {
            content += "" + p.value + "\n"
            p = p.next
        }
        println(content)
    }

    /**
     * 单链表反转
     * 不带头
     *
     * 时间复杂度: O(n)
     * 控件复杂度: O(1)
     */
    fun reverseList (head: Node?) : Node? {

        var newList: Node? = null
        var p = head
        var pNext: Node?

        while (p?.next != null) {
            pNext = p.next

            if (newList == null) {
                p.next = null
                newList = p
            } else {
                p.next = newList
                newList = p
            }

            p = pNext
        }

        p?.next = newList
        newList = p

        return newList
    }

    /**
     * 单链表反转
     * 带头
     */
    fun revereListWithHead (p: Node?) : Node? {

        //指定一个head
        var head = Node(8080)

        //head永远是head，遍历的买一个新节点插在head后面
        var q = p
        var qNext: Node? = null
        while (q != null) {
            qNext = q.next

            q.next = head.next
            head.next = q

            q = qNext
        }

        return head

    }

    /**
     * 链表中环的检测
     */
    fun hadCycle (head: Node?): Boolean {
        if (head == null) return false

        var fast = head.next
        var slow = head

        /**
         * 思路很厉害，从数学上讲：
         * 有环的链表，快指针一定会绕回来追赶慢指针，
         * 相对速度快1，所以一定可以重合相对速度快1，所以一定可以重合
         */
        while (fast != null && fast.next != null) {
            fast = fast?.next?.next
            slow = slow?.next

            if (slow == fast) return true
        }

        return false
    }

    /**
     * 链表中的换检测：开始入环的第一个节点
     */
    fun detectCycle (head: Node?) : Node? {
        if (head == null || head.next == null || head.next?.next == null) return null

        var fast = head.next?.next
        var slow = head.next

        //找到相遇点
        while (fast != slow) {
            if (fast?.next != null && fast?.next?.next != null) {
                fast = fast.next?.next
                slow = slow?.next
            } else {
                return null
            }
        }
        //找到入口
        fast = head
        while (fast != slow) {
            fast = fast?.next
            slow = slow?.next
        }

        return slow
    }

    /**
     * 合并两个有序链表
     *
     * 直观的做法(未使用哨兵节点)
     */
//    fun mergeTwoOrderedList (l1: Node?, l2: Node?) : Node? {
//
//        if (l1 == null) {
//            return l2
//        } else if (l2 == null) {
//            return l1
//        }
//
//        var head = l1
//        var p1 = head
//        var p2 = l2
//        var p1Pre: Node? = null
//        var p2Next: Node? = null
//
//        //把p2并入p1
//        while (p1 != null && p2 != null) {
//
//            //这里不可能是head
//            if (p1.value < p2!!.value) {
//
//                if (p1.next!!.value >= p2.value) {
//                    //在p1 与 p1.next之间：插入
//                    p2Next = p2.next
//
//                    p2.next = p1.next
//                    p1.next = p2
//
//                    p2 = p2Next
//                } else {
//                    //在p1右边，p1右移，再次运算
//                    p1Pre = p1
//                    p1 = p1.next
//                }
//            } else {
//
//                //p1是头结点，直接插入
//                if (p1 == head) {
//                        p2Next = p2.next
//                        p2.next = p1
//                        head = p2
//                        p1Pre = p2
//                        p2 = p2Next
//                } else {
//                    if (p1Pre!!.value <= p2!!.value) {
//                        //p2在p1 与 p1Pre之间
//                        p2Next = p2.next
//
//                        p2.next = p1
//                        p1Pre.next = p2
//                        p1Pre = p2
//
//                        p2 = p2Next
//                    } else {
//                        //p2在p1Pre之前，有序列表中，这种情况不会出现
//                    }
//                }
//            }
//        }
//
//        if (p2 != null) {
//            p1Pre?.next = p2
//        }
//
//        //使用原来的空间
//        return head
//    }

    /**
     * 合并两个有序列表
     * 使用了soldier节点简化问题
     */
    fun mergeTwoOrderedList (l1: Node?, l2: Node?) : Node? {

        var soldier = Node(0)
        var p = soldier
        var p1 = l1
        var p2 = l2


        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p.next = p1
                p1 = p1.next
            } else {
                p.next = p2
                p2 = p2.next
            }
            p = p.next!!
        }

        if (p1 == null) p.next = p2
        if (p2 == null) p.next = p1

        return soldier.next
    }

    /**
     * 删除链表中的倒数第N个节点
     *
     */
    fun removeNthFromEnd(head: Node?, n: Int): Node? {
        //思路：k已知，指针指向length-k+1个位置即可
        var fast = head
        var pos = 1

        while (fast != null && pos < n) {
            fast = fast.next
            ++pos
        }

        if (fast == null) return head

        var slow = head
        var prev: Node? = null

        while (fast?.next != null) {

            fast = fast?.next
            prev = slow
            slow = slow?.next
        }

        if (prev == null) {
            return head?.next
        } else {
            prev.next = prev.next?.next
            return head
        }

    }

    fun findMidNode (head: Node?) : Node? {

        if (head == null) return null

        var fast = head
        var slow = head

        if (fast.next != null && fast.next?.next != null) {
            fast = fast.next?.next
            slow = slow.next
        }

        return slow
    }

    companion object {

        fun printList (head: Node?) {

            var content = ""
            var p = head
            while (p != null) {
                content += "" + p.value + "\n"
                p = p.next
            }
            println(content)
        }
    }

}
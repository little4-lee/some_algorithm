package algo._03linkedlist

import common.ListNode


class SinglyLinkedList {

    var head: ListNode? = null

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
        val newListNode = ListNode(value)
        insertToTail(newListNode)
    }

    /**
     * 在链表尾部插入节点newListNode
     *
     * @param newListNode
     */
    fun insertToTail(newListNode: ListNode) {

        if (head == null) {
            head = newListNode
        } else {
            var q = head

            while (q?.next != null) {
                q = q.next
            }
            newListNode.next = q?.next
            q?.next = newListNode
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
    fun reverseList (head: ListNode?) : ListNode? {

        var newList: ListNode? = null
        var p = head
        var pNext: ListNode?

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
    fun revereListWithHead (p: ListNode?) : ListNode? {

        //指定一个head
        var head = ListNode(8080)

        //head永远是head，遍历的买一个新节点插在head后面
        var q = p
        var qNext: ListNode? = null
        while (q != null) {
            qNext = q.next

            q.next = head.next
            head.next = q

            q = qNext
        }

        return head.next

    }

    /**
     * 链表中环的检测
     */
    fun hadCycle (head: ListNode?): Boolean {
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
    fun detectCycle (head: ListNode?) : ListNode? {
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
//    fun mergeTwoOrderedList (l1: ListNode?, l2: ListNode?) : ListNode? {
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
//        var p1Pre: ListNode? = null
//        var p2Next: ListNode? = null
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
    fun mergeTwoOrderedList (l1: ListNode?, l2: ListNode?) : ListNode? {

        var soldier = ListNode(0)
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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        //思路：k已知，指针指向length-k+1个位置即可
        var fast = head
        var pos = 1

        while (fast != null && pos < n) {
            fast = fast.next
            ++pos
        }

        if (fast == null) return head

        var slow = head
        var prev: ListNode? = null

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

    fun findMidListNode (head: ListNode?) : ListNode? {

        if (head == null) return null

        var fast = head
        var slow = head

        if (fast.next != null && fast.next?.next != null) {
            fast = fast.next?.next
            slow = slow.next
        }

        return slow
    }

    /**
     * 链表
     * 每k位逆序
     */
    fun reverseEachKLength(head: ListNode?, k: Int) {
        if (head == null) return
        //哨兵节点
        var soldier = ListNode(8080)

        var pSlow = head
        var pFast = head
        while (pSlow != null) {
            var i = 0
            while (pFast != null && i < k ) {
                pFast = pFast?.next
                i++
            }

            if (i == k) {
                //reverse
                for (j in 0 until k) {
                    var temp = pSlow?.next
                    pSlow?.next = soldier.next
                    soldier.next = pSlow
                    pSlow = temp
                }
                for (l in 0 until k) {
                    soldier = soldier.next!!
                }
                continue
            } else {
                //add
                soldier.next = pSlow
                pSlow = null
                break
            }
        }
    }
}
package algo._02linkedlist;

import common.ListNode;

public class SinglyLinkedList {

    private ListNode head = null;

    public SinglyLinkedList (int[] data) {
        if (data == null || data.length == 0) return;

        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                head = new ListNode(data[i]);
            } else {
                insertToTail(data[i]);
            }
        }
    }

    public SinglyLinkedList () {

    }

    public ListNode findByValue (int value) {
        ListNode p = head;

        while (p != null && p.getValue() != value) {
            p = p.getNext();
        }

        return p;
    }

    public ListNode findByIndex (int index) {
        ListNode p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.getNext();
            pos++;
        }

        return p;
    }

    /**
     * 在链表头部插入值为value的节点
     *
     * @param value
     */
    public void insertToHead (int value) {
        ListNode newHead = new ListNode(value);
        insertToHead(newHead);
    }

    /**
     * 在链表头部插入节点newNode
     *
     * @param newNode
     */
    public void insertToHead (ListNode newNode) {
        if (head == null) {
            newNode.setNext(null);
        } else {
            newNode.setNext(head);
        }
        head = newNode;
    }

    /**
     * 在链表尾部插入值为value的节点
     *
     * @param value
     */
    public void insertToTail (int value) {
        ListNode newNode = new ListNode(value);
        insertToTail(newNode);
    }

    /**
     * 在链表尾部插入节点newNode
     *
     * @param newNode
     */
    public void insertToTail (ListNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            ListNode q = head;
            while (q.getNext() != null) {
                q = q.getNext();
            }
            newNode.setNext(q.getNext());
            q.setNext(newNode);
        }
    }


    /**
     * 在节点P后插入值为value的节点
     *
     * @param p
     * @param value
     */
    public void insertAfter (ListNode p, int value) {
        ListNode newNode = new ListNode(value);
        insertAfter(p, newNode);
    }

    /**
     * 在节点P后插入新节点newNode
     *
     * @param p
     * @param newNode
     */
    public void insertAfter (ListNode p, ListNode newNode) {
        if (p == null) return;

        newNode.setNext(p.getNext());
        p.setNext(newNode);
    }

    /**
     * 在节点p之前插入值为value的节点
     *
     * @param p
     * @param value
     */
    public void insertBefore (ListNode p, int value) {
        ListNode newNode = new ListNode(value);
        insertBefore(p, newNode);
    }

    /**
     * 在节点p之前插入节点newNode
     *
     * @param p
     * @param newNode
     */
    public void insertBefore (ListNode p, ListNode newNode) {
        if (head == null) return;

        if (p == head) {
            insertToHead(newNode);
            return;
        }

        ListNode q = head;
        while (q != null && p != q.getNext()) {
            q = q.getNext();
        }

        if (q == null) {
            return;
        }

        newNode.setNext(p);
        q.setNext(newNode);
    }

    /**
     * 删除链表中**第一个**值为value的节点
     *
     * @param value
     */
    public void deleteFirstByValue (int value) {
        if (head == null) return;

        ListNode p = head;
        ListNode q = null;

        while (p.getNext() != null && p.getValue() != value) {
            q = p;
            p = p.getNext();
        }

        if (p == null) return;

        if (q == null) {
            head = head.getNext();
        } else {
            q.setNext(p.getNext());
        }

    }

    /**
     * 删除链表中**所有**值为value的节点
     *
     * @param value
     */
    public void deleteAllByValue (int value) {

        if (head == null) return;

        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            if (p.getValue() == value) {
                if (p == head) {
                    head = head.getNext();
                    p = head;
                } else {
                    if (q != null) {
                        q.setNext(p.getNext());
                        p = p.getNext();
                    }
                }
                continue;
            }
            q = p;
            p = p.getNext();
        }
    }

    public void printLinkedList () {
        if (head == null) System.out.println("linked list is null");

        String content = "linked list: \n";
        ListNode p = head;
        while (p != null) {
            content += p.getValue() + "\n";
            p = p.getNext();
        }

        System.out.println(content);
    }

    /**
     * 删除链表中值为value的节点
     *
     * @param value
     * @param delAll true: 删除所有值为value的节点 false: 删除第一个值为value的节点
     */
    public void deleteByValue (int value, boolean delAll) {

        if (delAll) {
            deleteAllByValue(value);
        } else {
            deleteFirstByValue(value);
        }
    }

    /**
     * 删除节点delNode
     *
     * @param delNode
     */
    public void deleteByNode (ListNode delNode) {
        if (delNode == null || head == null) return;

        if (head == delNode) {
            head = head.getNext();
            return;
        }

        ListNode p = head;
        while (p.getNext() != null) {
            if (p.getNext() == delNode) {
                p.setNext(p.getNext().getNext());
                break;
            }
            p = p.getNext();
        }
    }

    /**
     * 判断两个链表数据是否完全一致
     *
     * @param left
     * @param right
     * @return
     */
    public boolean TFResult (ListNode left, ListNode right) {
        ListNode l = left;
        ListNode r = right;

        while (l != null && right != null) {
            if (l.getValue() == right.getValue()) {
                l = l.getNext();
                r = r.getNext();
                continue;
            } else {
                break;
            }
        }

        if (l == null && r == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 链表中环的检测
     * 空间复杂度O(1)
     * 时间复杂度O(n)
     */
    public boolean hadCycle (ListNode head) {
        if (head == null) return false;

        ListNode fast = head.getNext();
        ListNode slow = head;

        /**
         * 思路很厉害，从数学上讲：
         * 有环的链表，快指针一定会绕回来追赶慢指针，
         * 相对速度快1，所以一定可以重合
         */
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * 链表中环的检测
     * 返回第一个成环点
     * @param head
     * @return
     */
    public ListNode detectCycle (ListNode head) {
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) return null;

        ListNode fast = head.getNext().getNext();
        ListNode slow = head.getNext();

        //找到相遇点
        while (fast != slow) {
            if (fast.getNext() != null && fast.getNext().getNext() != null) {
                fast = fast.getNext().getNext();
                        slow = slow.getNext();
            } else {
                return null;
            }
        }
        //找到入口
        fast = head;
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow;
    }


    /**
     * 判断回文数
     *
     * @return
     */
    public boolean isPalindromicNumber () {

        if (head == null) return false;

        if (head.getNext() == null) {
            System.out.println("只有一个节点");
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertToHead(head);

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            list.insertToHead(slow);
        }

        ListNode left = null;
        ListNode right = null;
        if (fast.getNext() == null) {
            //整个队列节点数为奇数
            //slow是中点
            left = list.head;
            right = slow;
        } else {
            //整个队列节点数为偶数
            //slow 和 slow.next是中点
            left = list.head;
            right = slow.getNext();
        }

        return TFResult(left, right);
    }

}

package _02linkedlist;

public class SinglyLinkedList {

    private Node head = null;

    public SinglyLinkedList (int[] data) {
        if (data == null || data.length == 0) return;

        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                head = new Node(data[i]);
            } else {
                insertToTail(data[i]);
            }
        }
    }

    public SinglyLinkedList () {

    }

    public Node findByValue (int value) {
        Node p = head;

        while (p != null && p.getData() != value) {
            p = p.getNext();
        }

        return p;
    }

    public Node findByIndex (int index) {
        Node p = head;
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
        Node newHead = new Node(value);
        insertToHead(newHead);
    }

    /**
     * 在链表头部插入节点newNode
     *
     * @param newNode
     */
    public void insertToHead (Node newNode) {
        if (head == null) {
            newNode.setNext(null);
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    /**
     * 在链表尾部插入值为value的节点
     *
     * @param value
     */
    public void insertToTail (int value) {
        Node newNode = new Node(value);
        insertToTail(newNode);
    }

    /**
     * 在链表尾部插入节点newNode
     *
     * @param newNode
     */
    public void insertToTail (Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
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
    public void insertAfter (Node p, int value) {
        Node newNode = new Node(value);
        insertAfter(p, newNode);
    }

    /**
     * 在节点P后插入新节点newNode
     *
     * @param p
     * @param newNode
     */
    public void insertAfter (Node p, Node newNode) {
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
    public void insertBefore (Node p, int value) {
        Node newNode = new Node(value);
        insertBefore(p, newNode);
    }

    /**
     * 在节点p之前插入节点newNode
     *
     * @param p
     * @param newNode
     */
    public void insertBefore (Node p, Node newNode) {
        if (head == null) return;

        if (p == head) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
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

        Node p = head;
        Node q = null;

        while (p.getNext() != null && p.getData() != value) {
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

        Node p = head;
        Node q = null;
        while (p != null) {
            if (p.getData() == value) {
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
        Node p = head;
        while (p != null) {
            content += p.getData() + "\n";
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
    public void deleteByNode (Node delNode) {
        if (delNode == null || head == null) return;

        if (head == delNode) {
            head = head.getNext();
            return;
        }

        Node p = head;
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
    public boolean TFResult (Node left, Node right) {
        Node l = left;
        Node r = right;

        while (l != null && right != null) {
            if (l.getData() == right.getData()) {
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

        Node fast = head;
        Node slow = head;
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertToHead(head);

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            list.insertToHead(slow);
        }

        Node left = null;
        Node right = null;
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

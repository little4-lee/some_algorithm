package algo._02linkedlist;

import common.ListNode;
import org.jetbrains.annotations.NotNull;

import static common.ListUtilsKt.printList;

/**
 * @ClassName: LruLinkedList
 * @Author: elon
 * @CreateDate: 2022/11/15 11:32
 * @Description:
 */
public class LruLinkedList {

    public LruLinkedList() {
    }

    private ListNode head;
    private static final int MAX_LENGTH = 10;
    private int length = 0;

    public void add(@NotNull ListNode node) {
        //got, remove current,add to head
        if (findAndDelete(node.value)) {
            addToHead(node);
            return;
        }
        //not contained
        if (length == MAX_LENGTH) {
            removeTail();
        }
        addToHead(node);
    }

    private boolean findAndDelete(int key) {
        ListNode solder = new ListNode(0);
        solder.next = head;

        ListNode pre = solder;
        ListNode p = solder.next;

        while (p != null) {
            if (p.value == key) {
                pre.next = p.next;
                length--;
                head = solder.next;
                return true;
            }
            pre = p;
            p = p.next;
        }
        return false;
    }

    public ListNode get(int key) {
        ListNode p = head;
        while (p != null) {
            if (p.value == key) return p;
            p = p.next;
        }
        return null;
    }

    private void addToHead(@NotNull ListNode node) {
        if (head == null) {
            head = node;
            length++;
            return;
        }

        node.next = head;
        head = node;
        length++;
    }

    private ListNode removeTail() {
        if (head == null) {
            return null;
        }


        ListNode solder = new ListNode(0);
        solder.next = head;

        ListNode pre = solder;
        ListNode p = solder;
        while (p.next != null) {
            pre = p;
            p = p.next;
        }

        pre.next = null;
        head = solder.next;
        length--;
        return p;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public ListNode getList() {
        return head;
    }

    public static void main(String[] args) {
        LruLinkedList list = new LruLinkedList();
        for (int i = 8; i >= 0; i--) {
            list.add(new ListNode(i));
        }

        System.out.println("default: ");
        printList(list.getList());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.println("add: " + i);
            list.add(new ListNode(i));
            printList(list.getList());
            System.out.println();
        }

//        for (int i = 0; i <= 7; i++) {
//            list.addToHead(new ListNode(i));
//            printList(list.getList());
//            System.out.println();
//        }
    }
}

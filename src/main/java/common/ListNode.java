package common;

public class ListNode {
    public int value;
    public ListNode next;
    public ListNode (int x) { value = x; }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
